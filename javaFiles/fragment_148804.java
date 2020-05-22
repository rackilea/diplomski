public static ExpectedCondition<Boolean> waitForStock(final By locator) {
  return new ExpectedCondition<Boolean>() {
    @Override
    public Boolean apply(WebDriver driver) {
      try {
        WebElement elm = driver.findElement(locator);
        return elm.getText().trim().matches("[0-9]+");
      } catch (NoSuchElementException e) {
        return false;
      } catch (StaleElementReferenceException e) {
        return false;
      }
    }

    @Override
    public String toString() {
      return "stock is not yet loaded";
    }
  };
}