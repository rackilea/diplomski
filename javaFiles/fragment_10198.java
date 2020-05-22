@Bean
public MultipartConfigElement multipartConfigElement()
{
    MultipartConfigFactory factory = new MultipartConfigFactory();
    factory.setMaxFileSize("1000MB");
    factory.setMaxRequestSize("1000MB");
    return factory.createMultipartConfig();
}