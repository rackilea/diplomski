CompositeItemWriter<SimpleObject> compositeItemWriter = new CompositeItemWriter<>();
                List<org.springframework.batch.item.ItemWriter<? super SimpleObject>> delegates = new ArrayList<>();
                delegates.add(writer1);
                delegates.add(writer2);
                compositeItemWriter.setDelegates(delegates);

                TaskletStep processingStep = stepBuilderFactory.get(getLabel() + "-" + UUID.randomUUID().toString())
                        .<SimpleObject, SimpleObject>chunk(5)
                        .reader(reader)
                        .processor(processor)
                        .writer(compositeItemWriter)
                        .stream(writer1)
                        .stream(writer2)
                        .transactionManager(txManager)
                        .build();