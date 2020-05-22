@Bean
public FlatFileItemReader reader() {
    FlatFileItemReader reader = new FlatFileItemReader();
    ...
    reader.setComments(new String[] {"#"});
    return reader;
}