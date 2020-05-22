@SpringBootApplication
public class TomcatIcınApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TomcatIcınApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TomcatIcınApplication.class, args);
    }
}