List<WebElement> elements = driver.findElements(By.cssSelector(
  "#TDCON > tbody > tr > td:nth-child(4) > span > span:nth-child(2) > span > span > input"));

for (int i = 0; i < numberOfValues; i++) {
  try {
      elements[i].sendKeys(Keys.chord(Keys.CONTROL, "a"), value);
  }catch (NoSuchElementException ex) {
            break;
  }
}