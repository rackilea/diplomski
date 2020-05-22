@Configuration
@ComponentScan(basePackages = "com.djordje.cleanarchitecture")
public class WhatsTheTimeConfiguration {

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(trigger());
        schedulerFactoryBean.setJobDetails(jobDetail());
        schedulerFactoryBean.setJobFactory(springBeanJobFactory());
        return schedulerFactoryBean;
    }

    @Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        return new AutowiringSpringBeanJobFactory();
    }

    @Bean
    public JobDetail jobDetail() {
        JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setKey(new JobKey("WhatsTheTime"));
        jobDetail.setJobClass(WhatsTheTimeManager.class);
        jobDetail.setDurability(true);
        return jobDetail;
    }

    @Bean
    public SimpleTrigger trigger() {
        return newTrigger()
                .forJob(jobDetail())
                .withIdentity("whatsTheTimeJobTrigger", "jobsGroup1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();
    }
}