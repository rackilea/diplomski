@RunWith(Parameterized.class)
public class ClassATest extends EasyMockSupport {

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    private String uniqueIdentifier;
    private String value;

    @Mock
    private ClassB mockClassB;

    public ClassATest(String uniqueIdentified, String value) {
        this.uniqueIdentifier = uniqueIdentified;
        this.value = value;
    }

    @Parameterized.Parameters(name = "{index}: id = {0}; value = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1", "val1"},
                {"2", "val2"}});
    }

    @Test
    public void testMethod() {
        expect(mockClassB.someMethod(uniqueIdentifier)).andReturn(value);   // mockClassB is NULL
        replayAll();
    }
}