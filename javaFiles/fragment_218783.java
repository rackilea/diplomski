@SpringBootApplication
@EnableWebSecurity
@ImportResource({"classpath:/**/spring-security.xml"})
@ComponentScan(basePackages = {"net.kzn.onlineshopping.*","net.kzn.shoppingbackend.*"})
public class OnlineshoppingApplication  extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OnlineshoppingApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(OnlineshoppingApplication.class, args);
    }
}