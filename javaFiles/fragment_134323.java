@Component
public class MyComponent {

    @Autowired
    ApplicationContext ctx;

    public MyComponent(){

    }

    @PostConstruct
    public void init() {
        ctx.getBean(...); // do something
    }

}