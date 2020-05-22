@RunWith(Parameterized.class)
@SpringBootTest(classes = Application.class)
public class TargetClassTest {

    @Autowired
    private TargetClass instance;

    private TestContextManager testContextManager;

    String threshold;

    @Before
    public void setUpContext() throws Exception {
        this.testContextManager = new TestContextManager(getClass());
        this.testContextManager.prepareTestInstance(this);
    }


    @Parameters
    public static Collection<Object []> data() {
        return Arrays.asList(new Object[][]{
            {"0"},{"8"},
        });
    }

    public TargetClassTest(String test) {
        this.threshold = test;
    }

    @Test
    public void testSomething() throws Exception {
        String r = instance.businessMethod(threshold);
        Assert.assertEquals(threshold, r);
    }
}