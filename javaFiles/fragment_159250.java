@SpringBootApplication
 @ConditionalOnProperty(name = "myapp.active")
 public class FastFailWhenPropertyNotPresentApplication {

     public static void main(String[] args) {
            SpringApplication.run(FastFailWhenPropertyNotPresentApplication.class, args);
    }

}