@Test @Config(url="http://someurl.com", browser = Browser.CHROME)
public void myShortTest_CaseA() {
  setText("#username", "some_username")
  .setText("#password", "some_password")
  .click("#btn-login")
  .click("#a")
  .validatePresent("#something");
}

@Test @Config(url="http://someurl.com", browser = Browser.CHROME)
public void myShortTest_CaseB() {
  setText("#username", "some_username")
  .setText("#password", "some_password")
  .click("#btn-login")
  .click("#b")
  .validatePresent("#something-else");
}

@Test @Config(url="http://someurl.com", browser = Browser.CHROME)
public void myShortTest_CaseA() {
  setText("#username", "some_username")
  .setText("#password", "some_password")
  .click("#btn-login")
  .click("#c")
  .validatePresent("#something-else-else");
}