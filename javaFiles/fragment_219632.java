@SpringBootApplication
public class App {
    @Autowired
    public Starter starter;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    public App() {
        System.out.println("constructor of App");
    }

    @PostConstruct
    public void init() {
        System.out.println("Calling starter.init");
        starter.init();
    }
}