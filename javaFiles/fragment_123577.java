private void returnGoogleResults() {
  WebDriver driver = new ChromeDriver();
  List<WebElement> resultTitles = new ArrayList<>(((ChromeDriver) driver).findElementsByClassName(googleResultLocatorByClassName));
  if (!resultTitles.isEmpty() && resultTitles.get(0).equals(seleniumResultString)) {
    System.out.println(seleniumResultString + " is the first result!");
    driver.close();
  } else {
    System.out.println(seleniumResultString + " is not the first result!");
    driver.close();
  }

}