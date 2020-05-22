@PrepareForTest(Util.class)
public class PharmacyConstantsTest extends PowerMockTestCase {    
    ClassToTest classToTestSpy;

    @BeforeMethod
    public void beforeMethod() {
        classToTestSpy = spy(new ClassToTest());
    }

    @Test
    public void method() throws Exception {
        mockStatic(Util.class);
        when(Util.returnString()).thenReturn("xyz");
        classToTestSpy.methodToTest();
     }
 }