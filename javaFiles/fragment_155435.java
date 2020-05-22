@ManagedBean
@RequestScoped
public class HelloBean {

    @EJB
    HelloServiceLocal service;

    private String testString;

    public HelloBean(){
    }

    @PostConstruct
    public void init(){
      testString = service.sayHello();
    }