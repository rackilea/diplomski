public interface ABC {
    public String getAbc();
}

public class Do {

    @Inject
    ABC abc;

    public String doAbc() {
        System.out.println("Injected abc is " + (abc == null ? "null" : "not null"));
        return abc.getAbc();
    }

}


public class TestDo {
    @Mock
    private ABC abc;

    @InjectMocks
    private Do ddo;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void simpleTest() {
        System.out.println(ddo.doAbc());
    }

}