@Configuration
public class LocalDateConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
        registry.addFormatterForFieldType(LocalDate.class, new Formatter<LocalDate>() {
            //override parse() and print()
        });
    }
 }