@Bean
public ItemReader<Integer> itemReader() {
    return new ListItemReader<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
}

@Bean
public ItemProcessor<Integer, String> itemProcessor() {
    return item -> "foo" + item;
}

@Bean
public ItemWriter<String> itemWriter() {
    return items -> {
        for (String item : items) {
            System.out.println("item = " + item);
        }
    };
}

@Bean
public Step step() {
    return stepBuilderFactory.get("step")
            .<Integer, String>chunk(5)
            .reader(itemReader())
            .processor(itemProcessor())
            .writer(itemWriter())
            .build();
}