@SpringBootApplication
@ComponentScan({"com.mainpack", "com.msgpack.jms"})
@EnableJms
public class Application extends SpringBootServletInitializer {

    @Autowired
    private JmsTopicListener jmsTopicListener;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @PostConstruct
    public void listen() { 
        jmsTopicListener.listenMessage();
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        LogService.info(Application.class.getName(), "Service Started...");
    }
}