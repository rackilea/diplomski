SpringBeanJobFactory springBeanJobFactory = new SpringBeanJobFactory();

SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
schedulerFactoryBean.setTriggers(trigger());
schedulerFactoryBean.setJobFactory(springBeanJobFactory);
schedulerFactoryBean.start();
...
private static SimpleTrigger trigger() {
    return newTrigger()
            .withIdentity("whatsTheTimeJobTrigger", "jobsGroup1")
            .startNow()
            .withSchedule(simpleSchedule()
                    .withIntervalInSeconds(1)
                    .repeatForever())
            .build();
}