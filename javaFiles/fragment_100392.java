@Configuration
class SomeConfigClass {


    @Autowired
    SomeProperties someProperties

    @Value("${url1}")
    String url1

    @Value("${password1}")
    String password1

    ..............
     // Do this for other url's and properties or check out @ConfigurationProperties
    ..............

    @Bean("someService1")
    public SomeService() {
        return new SomeService(someProperties, url1, password1);
    }


    @Bean("someService2")
    public SomeService() {
        return new SomeService(someProperties, url2, password2);
    }

    ...............

    ..............
}