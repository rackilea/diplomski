@SpringBootApplication
public class Application {
public static void main(String[] args) {
    final ApplicationContext ctx = SpringApplication.run(Application.class, args);
}

@Bean
public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurerAdapter() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**").allowedOrigins("http://localhost:3000");
        }
    };
}
}