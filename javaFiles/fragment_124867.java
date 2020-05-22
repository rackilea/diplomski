@ComponentScan()
@EnableAutoConfiguration
public class MyApplication extends SpringBootServletInitializer {
    private static Logger LOG = LoggerFactory.getLogger(MyApplication.class);
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MyApplication.class, args);
        DispatcherServlet dispatcherServlet = (DispatcherServlet)ctx.getBean("dispatcherServlet");
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
    }