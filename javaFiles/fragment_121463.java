@Bean
@ConditionalOnMissingBean
public StringHttpMessageConverter stringHttpMessageConverter() {
    StringHttpMessageConverter converter = new StringHttpMessageConverter(
            this.properties.getCharset());
    converter.setWriteAcceptCharset(false);
    return converter;
}