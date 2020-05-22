@Bean
public Step step1() {
    return stepBuilderFactory.get("step1")
            .<Person, Person> chunk(10)
            .reader(reader(null))
            .processor(processor())
            .writer(writer())
            .build();
}