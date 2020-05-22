//...
By mySelector = By.xpath("/html/body/div[1]/div/section/div/div[2]/form[1]/div/ul/li");
List<WebElement> myElements = driver.findElements(mySelector);
for(WebElement e : myElements) {
  System.out.println(e.getText());
}