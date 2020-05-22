@Bean
public SchedulerFactoryBean schedulerFactoryBean() {
    SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
    scheduler.setTriggers(simpleTriggerFactoryBean().getObject(), cronTriggerFactoryBean().getObject());
    scheduler.setJobFactory(jobFactory());
    return scheduler;
}

@Bean
public JobFactory jobFactory() {
    return new AutowiringSpringBeanJobFactory();
}