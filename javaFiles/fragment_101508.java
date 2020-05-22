@SpringBootApplication(
    exclude = { DataSourceAutoConfiguration.class }
    //,scanBasePackages  = {"com.project.name.service"}
)

public class App implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(App.class);

    @Autowired
    private MyCustomService myCustomService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    public void run(String... args){
        myCustomService.anyMethod();
    }     
}