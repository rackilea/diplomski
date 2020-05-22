@Test
public void passingTest(){
  Assert.assertEquals(1, 1); // This will pass.
}

@Test
public void failingTest(){
  Assert.assertEquals(1,2); // This will fail.
}