@Test
public void test() {
    try {
       runTest();
       fail();
    } catch (InvocationTargetException x) {
       if( ! (x.getCause() instanceof IllegalArgumentException)) {
           fail();
       }
    }
}