String day = new Date().toString().split(" ")[0]; //returns day of week as for eg. Wed
List<WebElement> days = driver.findElements(By
        .xpath("//input[contains(@name,'dailyWeightGoal')]")); // Will get list of all input elements
for (WebElement webElement : days) {
    if (webElement.getAttribute("name").contains(day.toLowerCase())) // since the attribute name contains day, 
                                                                    //so checking like wise according to scenario
        webElement.sendKeys("0");
    else
        webElement.sendKeys("1");
}