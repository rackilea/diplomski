WebElement element = driver.findElement(By.xpath(locator1));
Select select = new Select(element);
List<WebElement> selectedOptions = select.getAllSelectedOptions();
for(WebElement selectedOption : selectedOptions) {
    System.out.println(selectedOption.getText());
}