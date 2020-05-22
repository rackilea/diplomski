@Test
public AssertionResult foo(){
   Bar actualBar = foo.doThat(...);
   if (actualBar == null){
       return AssertionResult.fail("actualBar == null");
   }
}