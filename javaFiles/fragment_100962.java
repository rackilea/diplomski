@Component
public class SomeBean implements InitializingBean {

    @Autowired
    private ServletContext context;   

    public void afterPropertiesSet() throws Exception {
       String path = context.getRealPath("/WEB-INF/LABLAB/RMI-Config.xml");
       //do something.
    }
}