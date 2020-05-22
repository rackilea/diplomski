@RunWith(MockitoJUnitRunner.class)
public class MyTestClass {
    private String theProperty;
    @Mock private MyClass mockObject;

    @Before
    public void setUp() {
        when(mockObject.myMethod(anyString())).thenAnswer(
            new Answer<String>(){
            @Override
            public String answer(InvocationOnMock invocation){
                if ("value".equals(theProperty)){
                    return "result";
                }
                else if("otherValue".equals(theProperty)) {
                    return "otherResult";
                }
                return theProperty;
            }});
    }
}