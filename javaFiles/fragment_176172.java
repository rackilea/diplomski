@Configuration
    @EnableAutoConfiguration
    @ComponentScan("controllers")
    @RestController
    public class SimpleAppApplication extends SpringBootServletInitializer {

        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application;
        }

        public static void main(String[] args) {
            SpringApplication.run(SimpleAppApplication.class, args);
        }
    }