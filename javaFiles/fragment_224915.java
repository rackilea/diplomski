@SpringBootApplication
public class Application extends SpringBootServletInitializer {

@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
    }

public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
    }

}