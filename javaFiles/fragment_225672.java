@Test
public void randomTest(){
  int random = randomFunction();
  int high = 10;
  int low = 5;
  assertTrue("Error, random is too high", high >= random);
  assertTrue("Error, random is too low",  low  <= random);
  //System.out.println("Test passed: " + random + " is within " + high + " and + low);
}