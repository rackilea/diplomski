interface One {
  int alwaysOne();
}

class OneTest {
   One one = new OneImpl(); //You can implement OneImpl as an exercise
   @Test
   public void testAlwaysOne() {
     assertEquals("Should ALWAYS return 1", 1, one.alwaysOne());
   }
 }