@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.websystique.springmvc")
@EnableJpaRepositories(basePackages = "com.websystique.springmvc")
public class HelloWorldConfiguration {
    ...
}