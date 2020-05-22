@Bean
public SchedulerFactoryBeanWithWait schedulerFactoryBeanWithWait (
        JobFactory jobFactory,
        @Qualifier("MemoryDataUpdateJobTrigger") Trigger memoryDataUpdateJobTrigger,
        @Qualifier("MsgCountJobTrigger") Trigger msgCountJobTrigger) throws IOException {
    SchedulerFactoryBeanWithWait factory = new SchedulerFactoryBeanWithWait ();
    factory.setJobFactory(jobFactory);
    factory.setQuartzProperties(quartzProperties());
    factory.setTriggers(memoryDataUpdateJobTrigger, msgCountJobTrigger);
    return factory;
}