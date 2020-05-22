@Configuration
@ComponentScan({"your.service.packages"})
@EntityScan(basePackages = "your.model.package")
@EnableJpaRepositories("your.repository.packages")
@EnableRabbit // probaby
@EnableWebMvc // probably
public class Config {
   //you could also define other beans here
   @Bean
   public SomeBean someBean() {
       return new SomeBean();
   }
}