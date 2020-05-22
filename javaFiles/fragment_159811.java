public class MyTest {
    boolean methodCalled = false;

    @Test
    public void testMySubclass(){
          TestSomeClass testSomeClass = new TestSomeClass();
          // Invoke method on testSomeclass ...
          assertTrue( methodCalled);

    }  
    class TestSomeClass extends SomeClass{
        public String method(String code){
              methodCalled = true;
        } 
     }
}