@Bean
public FlatFileItemReader<String> itemReader() {
    return new FlatFileItemReaderBuilder<String>()
            .name("itemReader")
            .resource(new FileSystemResource("/absolute/path/to/file"))
            .lineMapper(new PassThroughLineMapper())
            .build();
}