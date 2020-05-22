@SpringBootApplication(
    exclude = { DataSourceAutoConfiguration.class }
    //,scanBasePackages  = {"com.project.name.service"}
)

public class App{

    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

        MyCustomService myCustomService = (MyCustomService)context.getBean("myCustomService");
        ...

        myCustomService.anyMethod();
    }
}