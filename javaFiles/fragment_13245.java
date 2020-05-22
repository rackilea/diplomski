@Bean
@Scope("prototype")
public WsPort getPort() {
    return new MyWebService().getWsPort();
}

@Service
public class MyClient {
    @Autowired
    private WsPort port;

    ...

    public void myMethod(){
        addCredentials(port, username2, pass2);
        ...
    }
}