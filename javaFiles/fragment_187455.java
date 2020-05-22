List<WebElement> children = parent.findElements(By.tagName("rect"));
genericControls.waitCommands.fluentWaitOnBarChartSelector(driver);
for (WebElement child : children) {
    if (children.indexOf(child) > 2)
        break;
    child.click();
}