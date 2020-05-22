@Configuration
@EnableWebMvc
@ComponentScan("ru.mypackage")
@EnableTransactionManagement
public class WebConfig extends WebMvcConfigurerAdapter {
    // ... Your code 
}