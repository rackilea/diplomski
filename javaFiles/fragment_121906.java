@Bean
public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
    PropertySourcesPlaceholderConfigurer placeholderConfigurer= new PropertySourcesPlaceholderConfigurer();
    //placeholderConfigurer.setLocation(new ClassPathResource("second.properties"));

    return placeholderConfigurer;
}