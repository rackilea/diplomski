@Bean
Step step1() {
    return stepBuilderFactory.get("step1")
            .listener(dataProcessor)
            .chunk(100)
            .faultTolerant()
            .reader(yourReader()).faultTolerant().skipPolicy(new ItemVerificationSkipper())
            .processor(dataProcessor)
            .writer(writer())
            .build();
}