@Bean
public Step generateDemmandeCommunication(InMemoryMouvementReader reader, MouvementToMapItemProcessor mvts) {
    return stepBuilderFactory.get("generateDemmandeCommunication")
            .<MouvementFileRow, DemandeCommunication>chunk(10)
            .faultTolerant().skipLimit(Integer.MAX_VALUE).skip(CustomReaderSkipException.class)
            .reader(reader)
            .processor(mvts)
            .writer(demandeCommunicationItemWriter())
            .listener(customStepListener())
            .build();
}