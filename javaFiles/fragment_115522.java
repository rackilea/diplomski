@SpringBootApplication
public class DemoApplication {
    @Autowired IUsesExample usesExample;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    void run() {
        usesExample.doThing();
    }
}