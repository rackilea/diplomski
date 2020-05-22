@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.smartintranet")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @PersistenceContext
    private EntityManager entityManager;

    // (....rest of the methods.......)

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addFormatter(new PositionFormatter(entityManager));
    }
}