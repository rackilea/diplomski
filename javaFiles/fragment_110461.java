@SpringBootApplication
@ImportResource("applicationContext.xml")
public class ExampleApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExampleApplication.class, args);
    }

}