@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

@Autowired
private MyProperties props;

public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
}

@PostConstruct
public void postConstruct() {
    System.out.print("Print my property: " + props.myProperty);
}
}