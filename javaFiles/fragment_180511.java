@Bean
public FlatFileItemReader<Person> reader() {
    return new FlatFileItemReaderBuilder<Person>().name("personItemReader")
            .resource(new ClassPathResource("sample-data.csv"))
            .lineMapper(lineMapper()).build();
}

@Bean
public DefaultLineMapper<Person> lineMapper(){
      DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();
      lineMapper.setLineTokenizer(lineTokenizer());
      lineMapper.setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {
                {
                    setTargetType(Person.class);
                }
            });
      return lineMapper;
}

@Bean
public DelimitedLineTokenizer lineTokenizer() {
    DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer(DelimitedLineTokenizer.DELIMITER_TAB);
    tokenizer.setNames(new String[] { "firstName", "lastName" });
    return tokenizer;
}