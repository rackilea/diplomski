@Configuration
public class SomeConfiguration {

   @Bean
   public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(Environment e) {
      ((StandardServletEnvironment)e).getPropertySources().addLast(new ResourcePropertySource("<path-to-properties-file>"));
   }
}