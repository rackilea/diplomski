public int getNumberOfElementsFound(By by) {
    return webDriver.findElements(by).size();
  }

  public WebElement getElementWithIndex(By by, int pos) {
    return webDriver.findElements(by).get(pos);
  }