@PrepareForTest(IdGenerator.class)
public class MyTestClass {

   @Test
   public void demoStaticMethodMocking() throws Exception {
      mockStatic(IdGenerator.class);
      when(IdGenerator.generateNewId()).thenReturn(2L);       
      new ClassUnderTest().methodToTest();

      // Optionally verify that the static method was actually called
      verifyStatic();
      IdGenerator.generateNewId();
   }

}