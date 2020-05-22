@Configuration
@ComponentScan (basePackages = { "com.test" })
@EnableAutoConfiguration(exclude = {MetricFilterAutoConfiguration.class, MetricRepositoryAutoConfiguration.class})
@Domain(basePackages = { "com.test.domain" })
public class Application {        
       //some code
}