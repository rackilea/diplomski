@Configuration
public class SpringRestConfiguration {

    @Bean
    public BeanThatNeedsParamters beanThatNeedsParamters (@Qualifier("parameters") Parameters parameters) {
       return new BeanThatNeedsParamters(parameters)
    }

}