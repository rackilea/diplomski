@Configuration
    @EnableWebMvc
    public class ConsoleConfiguration extends WebMvcConfigurerAdapter{
       public void addFormatters(final FormatterRegistry registry) {
          super.addFormatters(registry);
          registry.addConverter(new ExperimentToStringConverter());
          registry.addConverter(new StringToExperimentConverter());
       }
    }