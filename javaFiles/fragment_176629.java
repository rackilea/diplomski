@Configuration
@ComponentScan("com.TayrosCapital.investsuiteNG")
@EnableWebMvc
@EnableTransactionManagement
@Import({SecurityConfig.class})
@PropertySource("classpath:properties/application.properties")
public class Config extends WebMvcConfigurerAdapter implements EnvironmentAware{

private Environment environment;

    @Override
    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }


///other beans instantiations

}