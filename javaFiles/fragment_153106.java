List<WebElement> lc = driver.findElements(By.cssSelector("table[id*='filter']"));

for (WebElement row : lc) {
  List<WebElement> images = row.findElements(By.tagName("img"));

  for (WebElement image : images) {
    image.click();
  }
}