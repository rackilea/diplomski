@EnableScheduling
@EnableAspectJAutoProxy
@EnableCaching
@Configuration
@ComponentScan(basePackages = { "org.kemri.wellcome.hie" }, 
    excludeFilters = {@Filter(value = Controller.class, type = FilterType.ANNOTATION)})
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}