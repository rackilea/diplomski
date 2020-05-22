public class WebAppConfig extends WebMvcConfigurerAdapter {

    //...

    @Bean
    public ContestFlow contestFlow()
    {
        return new ContestFlow();       
    }

}