@Service
public class MyBean {
    @PostConstruct
    public void init() {
        //construction logic here...
        //printing a message for demonstration purposes
        System.out.println("Bean is already created and resources have been injected!");
    }
}