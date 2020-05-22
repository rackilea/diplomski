@Component
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("META-INF/config.xml");

        Main p = context.getBean(Main.class);
        p.start(args);
    }

    @Autowired
    private MyBean myBean;
    private void start(String[] args) {
        System.out.println("my beans method: " + myBean.getStr());
    }
}

@Service 
public class MyBean {
    public String getStr() {
        return "string";
    }
}