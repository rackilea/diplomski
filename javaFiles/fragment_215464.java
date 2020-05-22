@Configuration
@EnableWebMvc
@EnableJpaRepositories("your-base-package-here")
@ComponentScan(basePackages = { "com.xyz" })
public class WebMvcConfig extends WebMvcConfigurerAdapter {

}