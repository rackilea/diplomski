@Component
public class HelloStoreResolver {

    @Autowired
    private HelloStore oneHelloStore;

    @Autowired
    private HelloStore twoHelloStore;

    public HelloStore get() {
        if (condition) {
            return oneHelloStore;
        } else {
            return twoHelloStore;
        }
    }

}


@Component
public class HelloController {

    @Autowired
    private HelloStoreResolver helloResolver;

    //annotations omitted
    public String sayHello() {
        return helloResolver.get().hello();
    }

}