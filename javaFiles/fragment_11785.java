@Configuration
@Import(CountryConfig.class)
public class ApplicationConfiguration {

    @Inject
    private List<Color> colorList;

    @Bean
    public Color color() {
      return new Blue();//injects Blue object to colorList
    }

    @Bean
    public Color color() {
      return new Red();//injects Red object to colorList
    }
}