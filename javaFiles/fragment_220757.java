@Bean
public FreeMarkerConfigurer freeMarkerConfigurer() {
    FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
    configurer.setTemplateLoaderPaths("one", "two", "three");

    // Apply further configuration as needed

    return configurer;
}