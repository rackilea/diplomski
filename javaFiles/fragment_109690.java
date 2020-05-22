@Bean
public Jackson2ObjectMapperBuilder jacksonBuilder() {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();

    // Customize
    builder.indentOutput(true).dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    return builder;
}