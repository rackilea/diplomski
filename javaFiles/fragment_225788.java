package de.scrum_master.stackoverflow;

public class Application {
  static WebDriver webDriver;

  static void myOverloadedMethod(String text) {}
  static void myOverloadedMethod(WebElement text) {}

  public static void main(String[] args) {
    // These 3 variants work
    myOverloadedMethod("test");
    myOverloadedMethod((WebElement) webDriver.findElement());
    WebElement webElement = webDriver.findElement();
    myOverloadedMethod(webElement);

    // This one does not work
    myOverloadedMethod(webDriver.findElement());
  }
}