public class TestClass {
 @Before
 public void setup() {
 //prepare information
 }

 @Test
 public void testCheck_Ean() {
   boolean result = Check_Ean(...); 
   Assert.assertTrue(result);
 }

 @After
 public void destroy() {
  //if you need to "destroy" some info
 }

}