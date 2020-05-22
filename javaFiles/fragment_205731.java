@Bean(name="conversionService")
public ConversionService getConversionService() {
    ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
    bean.setConverters(...); //add converters
    bean.afterPropertiesSet();
    return bean.getObject();
}