@Bean
@StepScope
public ItemReader<String[]> itemReader(
        @Value("#{jobParameters['fileName']}") String fileName,
        @Value("#{jobParameters['columnNames']}") String columnNames
        ) {
    return new FlatFileItemReaderBuilder<String[]>()
            .name("hacReader")
            //put file here
            .resource(new FileSystemResource(fileName))
            .lineMapper(new DefaultLineMapper<String[]>() {{
                setLineTokenizer(new DelimitedLineTokenizer() {{
                    //put column names here
                    setNames(columnNames.split(","));
                }});
            }})
            .build();
}