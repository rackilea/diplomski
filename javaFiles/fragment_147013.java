@PrepareForTest(Util.class)
@RunWith(PowerMockRunner.class)
public class UtilTest {

   @Test
   public void testMethod() throws Exception {
      PowerMockito.spy(Util.class);
      PowerMockito.doReturn("abc").when(Util.class, "anotherMethod");

      String retrieved = Util.method();

      Assert.assertNotNull(retrieved);
      Assert.assertEquals(retrieved, "abc");
   }
}