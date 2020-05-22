@Import({DatabaseConfiguration.class, MailSenderConfiguration.class})
public class AppConfig {
@Bean
public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
    PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
    propertyPlaceholderConfigurer.setLocations(new ClassPathResource("application.properties"), new ClassPathResource("mail.properties"));
    propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
    return propertyPlaceholderConfigurer;
}