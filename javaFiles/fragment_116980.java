public static ExpectedCondition<WebElement> elementToBeClickableInFrame(final By locatorFrame, final By locator) {
  return new ExpectedCondition<WebElement>() {

    @Override
    public WebElement apply(WebDriver driver) {
      try {

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(locatorFrame));

        WebElement elem = driver.findElement(locator);
        return elem.isDisplayed() && elem.isEnabled() ? elem : null;

      } catch (Exception e) {
        return null;
      }
    }

    @Override
    public String toString() {
      return "element located by: " + locator + " in " + locatorFrame;
    }
  };
}