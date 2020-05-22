@Before
public void setUp() {
    doAnswer(new Answer<String>(){
        @Override
        public String answer(InvocationOnMock invocation){
            if ("value".equals(theProperty)){
                return "result";
            }
            else if("otherValue".equals(theProperty)) {
                return "otherResult";
            }
            return theProperty;
        }}).when(mockObject).myMethod(anyString());
}