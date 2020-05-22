@Bean
    public Step step2() throws IOException, InterruptedException {
        return stepBuilderFactory.get("step2").<Bill, Bill>chunk(1000)
                .reader(multiResourceItemReader(null))
                .writer(writer())
                .build();
    }