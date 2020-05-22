@Configuration
public class SampleConfig {

    // other configs...

    @Bean
    public static PropertyPlaceholderConfigurer placeHolderConfigurer(){
      PropertyPlaceholderConfigurer placeHolderConfigurer = new PropertyPlaceholderConfigurer();
      ClassPathResource[] cpResources = new ClassPathResource[]
              { new ClassPathResource( "someFile.properties" ) };
      placeHolderConfigurer.setLocations(cpResources);
      placeHolderConfigurer.setIgnoreUnresolvablePlaceholders(true);
      return placeHolderConfigurer;
    }
}