@Test @Config(url="http://someurl.com", browser = Browser.CHROME)
public void myLongTest() {
  setText("#username", "some_username")
  .setText("#password", "some_password")
  .click("#btn-login")
  .store("some_variable", getText("#element");
  // some_variable will be "a" | "b" | "c"
  switch ((String) get("some_variable")) {
    case "a":
      click("#a")
      .validatePresent("#something");
      break;
    case "b":
      click("#b")
      .validatePresent("#something-else");
      break;
    case "c":
      click("#c")
      .validatePresent("#something-else-else");
      break;
  }
}