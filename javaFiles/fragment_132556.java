@Bean
public class Caller {
    @Autowired
    private WebServiceCaller caller;

    public void callWith10Threads() {
        for (int i = 0; i < 10; i++) {
            caller.callWebService();
        }
    }
}