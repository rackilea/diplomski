@Service
public class MyClient {
    @Autowired
    private ApplicationContext context;

    ...

    public void myMethod(){
        context.getBean("port1", WsPort.class).doWhatever();        
    }
}