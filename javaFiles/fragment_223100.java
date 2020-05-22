driver.findElement(By.id("imgSelectButton")).click();
List<WebElement> list = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.logoSelect > ul li.logoSelectOpt")));
System.out.println(list.size());
for(int i=0; i<list.size(); i++){
    System.out.println(list.get(i).getText());
    if (list.get(i).getText().contains("History")){
        list.get(i).click();
        break;
    }
}