@Test
public void testResource() {
    System.setProperty("value", "123");
    System.setProperty("resource", "location:not.found");
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(TestConfig.class);
    context.refresh();
    Resource resource = context.getBean("resource", Resource.class);
    assertTrue(resource.exists());
}

@Configuration
@Import(ConversionConfig.class)
public static class TestConfig {

    @Value("${resource}")
    private Resource resource;

    @Bean
    public Resource resource() {
        return resource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholders() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}

@Configuration
public static class ConversionConfig {

    @Bean
    protected ConversionService conversionService(final ResourceLoader loader) {
        GenericConversionService service = new GenericConversionService();
        service.addConverter(new Converter<String, Resource>() {
            public Resource convert(String location) {
                Resource resource = loader.getResource(location);
                if (resource.exists()) {
                    return resource;
                }
                return new ByteArrayResource("foo".getBytes());
            }
        });
        return service;
    }

}