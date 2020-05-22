@Configuration
public class ApplicationStartupConfig implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private Environment env;

    public static String prop;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        prop = env.getProperty("property.path");
    }
}