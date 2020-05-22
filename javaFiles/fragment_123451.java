public class MyService {
    public MyService() {}
}

@Configuration
public class Application {

    @Bean
    public MyService myService() {
        return new MyService();
    }

    @Autowired
    @Bean
    public MyOtherService myOtherService(MyService myService) {
        return new MyOtherService();
    }
}