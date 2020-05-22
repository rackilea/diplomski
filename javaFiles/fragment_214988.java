@Configuration
@ComponentScan(basePackages="com.sivalabs.jcart")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.sivalabs.jcart")
@EntityScan(basePackages="com.sivalabs.jcart")
public class Application{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}