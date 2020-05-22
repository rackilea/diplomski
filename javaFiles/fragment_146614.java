@Bean
public Job newsSyncJob() {
    log.debug("Building batch newsSyncJob...");
    this.init();
    return jobBuilderFactory.get("newsSyncJob")
            .incrementer(new RunIdIncrementer())
            .start(step1())
            .build();
}

@Bean
protected Step step1() {
    return stepBuilderFactory.get("step1")
            .<NewsSync, NewsSync> chunk(4)
            .reader(filesReader()).
            processor(newsProcessor()).
            writer(stateWriter()).
            build();
}