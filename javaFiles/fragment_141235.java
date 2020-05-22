List<WebElement> component = componentsDialog.findElements(By.xpath("@class='component' and @componentId = '" + componentId + "']"));
if (component.isEmpty())
{
    log.error("Component not found");
    driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
    componentsDialog.findElement(By.className("addbutton")).click();
}
else
{
    component.get(0).click();
}