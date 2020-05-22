@SpringBootApplication
@EntityScan(basePackages = {"com.baotrung.*"})
@EnableJpaRepositories(basePackages = {"com.baotrung.*"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}