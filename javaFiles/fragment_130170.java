public class SomeTest {
   @Tested CodeUnderTest tested;
   @Injectable Dependency dep1;
   @Injectable AnotherDependency dep2;
   @Injectable int someIntegralProperty = 123;

   @Test
   public void someTestMethod(@Injectable("true") boolean flag, @Injectable("Mary") String name)
   {
      // Record expectations on mocked types, if needed.

      tested.exerciseCodeUnderTest();

      // Verify expectations on mocked types, if required.
   }
}