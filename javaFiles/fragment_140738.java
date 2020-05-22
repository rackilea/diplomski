String expectedtext="Dear Tester, \n\nLine 1\n\nLine 2\n\nLine 3\n\nLine 4";

public void verifyText(){
  String actualtext = driver.getSingleElement(PAGETEXT).getText();
  Assert.assertEquals(actualtext, expectedtext);
}