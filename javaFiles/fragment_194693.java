@Component
public class Boo {

    private static Foo foo;
    @Autowired
    private Foo tFoo;

    @PostConstruct
    public void init() {
        Boo.foo = tFoo;
    }

    public static void randomMethod() {
         foo.doStuff();
    }
}