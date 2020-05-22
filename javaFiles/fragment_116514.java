/**
 * This class listeners to ContextStartedEvent, and when the context is started
 * gets all bean definitions, looks for the @ScheduledJob annotation,
 * and registers quartz jobs based on that.
 *
 * Note that a new instance of the quartz job class is created on each execution,
 * so the bean has to be of "prototype" scope. Therefore an applicationListener is used
 * rather than a bean postprocessor (unlike singleton beans, prototype beans don't get
 * created on application startup)
 *
 * @author bozho
 *
 */
 public class QuartzScheduledJobRegistrar implements
    EmbeddedValueResolverAware, ApplicationContextAware,
    ApplicationListener<ContextRefreshedEvent> {

private Scheduler scheduler;

private StringValueResolver embeddedValueResolver;

private Map<JobListener, String> jobListeners;

private ApplicationContext applicationContext;

public void setEmbeddedValueResolver(StringValueResolver resolver) {
    this.embeddedValueResolver = resolver;
}

public void setApplicationContext(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
}

@SuppressWarnings("unchecked")
@Override
public void onApplicationEvent(ContextRefreshedEvent event) {
    if (event.getApplicationContext() == this.applicationContext) {
        try {
            scheduler.clear();

            for (Map.Entry<JobListener, String> entry : jobListeners.entrySet()) {
                scheduler.getListenerManager().addJobListener(entry.getKey(), NameMatcher.nameStartsWith(entry.getValue()));
            }
        } catch (SchedulerException ex) {
            throw new IllegalStateException(ex);
        }

        DefaultListableBeanFactory factory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        String[] definitionNames = factory.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            BeanDefinition definition = factory.getBeanDefinition(definitionName);
            try {
                if (definition.getBeanClassName() != null) {
                    Class<?> beanClass = Class.forName(definition.getBeanClassName());
                    registerJob(beanClass);
                }
            } catch (ClassNotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
}

public void registerJob(Class<?> targetClass) {
    ScheduledJob annotation = targetClass.getAnnotation(ScheduledJob.class);

    if (annotation != null) {
        Assert.isTrue(Job.class.isAssignableFrom(targetClass),
                "Only classes implementing the quartz Job interface can be annotated with @ScheduledJob");

        @SuppressWarnings("unchecked") // checked on the previous line
        Class<? extends Job> jobClass = (Class<? extends Job>) targetClass;

        JobDetail jobDetail = JobBuilder.newJob()
            .ofType(jobClass)
            .withIdentity(
                    annotation.name().isEmpty() ? targetClass.getSimpleName() : annotation.name(),
                    annotation.group().isEmpty() ? targetClass.getPackage().getName() : annotation.group())
            .storeDurably(annotation.durable())
            .requestRecovery(annotation.shouldRecover())
            .build();

        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger()
            .withIdentity(jobDetail.getKey().getName() + "_trigger", jobDetail.getKey().getGroup() + "_triggers")
            .startNow();

        String cronExpression = annotation.cronExpression();
        long fixedRate = annotation.fixedRate();
        if (!BooleanUtils.xor(new boolean[] {!cronExpression.isEmpty(), fixedRate >=0})) {
            throw new IllegalStateException("Exactly one of 'cronExpression', 'fixedRate' is required. Offending class " + targetClass.getName());
        }

        if (!cronExpression.isEmpty()) {
            if (embeddedValueResolver != null) {
                cronExpression = embeddedValueResolver.resolveStringValue(cronExpression);
            }
            try {
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        }


        if (fixedRate >= 0) {
            triggerBuilder.withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInMilliseconds(fixedRate)
                            .repeatForever())
                .withIdentity(jobDetail.getKey().getName() + "_trigger", jobDetail.getKey().getGroup() + "_triggers");
        }

        try {
            scheduler.scheduleJob(jobDetail, triggerBuilder.build());
        } catch (SchedulerException e) {
            throw new IllegalStateException(e);
        }
    }
}

public void setScheduler(Scheduler scheduler) {
    this.scheduler = scheduler;
}

public void setJobListeners(Map<JobListener, String> jobListeners) {
    this.jobListeners = jobListeners;
}
}