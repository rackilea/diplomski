@Bean
    @StepScope
    protected Step step2(ItemReader<someDto> reader,
                        ItemWriter<someDto> writer ,ItemWriter<someDto> topicWriter,"#{jobParameters['writerType']}") final String type ) {

                            ItemWriter<someDto> myWriter;           
                            if(type.equals("topic"))
                            {
                                myWriter=topicWriter;
                            }
                            else
                            {
                                myWriter=writer;
                            }

        return stepBuilderFactory.get(BatchConstants.STEP_NAME)
                .<someDto, someDto> chunk(BatchConstants.CHUNKSIZE)
                .reader(reader)
                .writer(myWriter) 
                .build();
    }