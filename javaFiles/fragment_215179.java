@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestCaseResourceTest1.class,
    TestCaseResourceTest2.class
)}
public class TestSuiteClass {

    @BeforeClass
    public void setup() {
        beforeFileTest();
    }

    private void beforeFileTest() throws Exception {
        // ...
    }
}