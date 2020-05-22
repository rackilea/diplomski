public class SimpleExpectedExceptionTest {
   @Rule
   public ExpectedException thrown= ExpectedException.none();

   @Test
   public void myMethod_throws_no_exception_when_passed_greeting() {
       fixture.myMethod("hello");
   }

   @Test
   public void myMethod_throws_MyException_when_passed_farewell() {
       thrown.expect(MyException.class);
       fixture.myMethod("goodbye");
   }
}