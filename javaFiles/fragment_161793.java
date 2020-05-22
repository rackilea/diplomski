@SpringBootApplication
public class UpperFunctionApplication {

    @Bean
    public MyService myService() {
       return new MyService(); // You must provide code to construct new MyService bean
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UpperFunctionApplication.class, args);
    }
}