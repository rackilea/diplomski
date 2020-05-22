@SpringBootApplication
@PropertySource("classpath:config/mailing.properties")
public class DemoApplication implements CommandLineRunner {

@Autowired
private MailService mailService;

public static void main(String[] args) throws Exception {
    SpringApplication.run(DemoApplication.class, args);
}

@Override
public void run(String... arg0) throws Exception {
    String s = mailService.getMailFrom();
    System.out.println(s);
}