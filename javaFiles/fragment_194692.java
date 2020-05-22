@Component
public class Boo {

    private static Foo foo;

    @Autowired
    public Boo(Foo foo) {
        Boo.foo = foo;
    }

    public static void randomMethod() {
         foo.doStuff();
    }
}