@StepScope
    @Bean
    public MultiResourceItemReader<Bill> multiResourceItemReader(@Value("file:*.tsv") Resource[] inputResources) throws InterruptedException, IOException {
        log.info("start MultiResourceItemReader");
        MultiResourceItemReader<Bill> resourceItemReader = new MultiResourceItemReader<Bill>();
        resourceItemReader.setResources(inputResources);
        resourceItemReader.setDelegate(reader());
        return resourceItemReader;
    }