private <T> void flatFileItemReaderConfig(FlatFileItemReader<T> flatFileReader, String fileName, String incomingHeader, Class<T> clazz) {

    // set delimitter as '|'
    DefaultLineMapper<T> defaultLineMapper = new DefaultLineMapper<>();

    DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer("|");
    delimitedLineTokenizer.setNames(convertHeaderToEntityAttrib(fileName, incomingHeader));
    defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);

    // convert each record into primaryentity
    BeanWrapperFieldSetMapper<T> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
    beanWrapperFieldSetMapper.setTargetType(clazz);
    beanWrapperFieldSetMapper.setCustomEditors(getCustomFormatters());
    defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
    flatFileReader.setLineMapper(defaultLineMapper);
}