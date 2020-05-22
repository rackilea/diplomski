@Primary
@Bean
public ObjectMapper mapper() {
    // Customize...
    return new ObjectMapper().setLocale(Locale.UK);
}