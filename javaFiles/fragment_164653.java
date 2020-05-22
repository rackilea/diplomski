@RunWith(Parameterized.class)
class MyTest{

    @Parameters
    public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                            { { 0, 0, 0, 2 },... });
    }


     int x,y,z, expectedResult;

   // add constructor here

   @Test
   public void testYEqualToZ(){
      int actualResult = Misc.computeValue(x,y,z);
      assertEquals(actualResult, expectedResult);
     }
}