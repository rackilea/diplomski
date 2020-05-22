@SpringBootApplication
public class DemoApplication {

public static void main(String[] args) {
    ConfigurableApplicationContext ctx = SpringApplication.run(
            DemoApplication.class, args);
    for (String name : ctx.getBeanNamesForType(Toto.class)) {
        System.out.println(name);
    }
}
}