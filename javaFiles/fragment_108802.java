@ComponentScan(basePackages = {"com.xxc", "lk.xcc"})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SpringBootWebApplication {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(SpringBootWebApplication.class, args);
  }
}