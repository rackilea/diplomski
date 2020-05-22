List<WebElement> allLinks = driver.findElements(By.xpath("//img[@alt='Online Now!']/../..//a"));
//have found links of all online profiles
System.out.println(allLinks.size());
for (WebElement link : allLinks)
{
    String originalWindow =driver.getWindowHandle();
            System.out.println("Original handle is: "+ originalWindow);
//open link in new window
            act.contextClick(link).perform();
            act.sendKeys("w").perform();

            Thread.sleep(4000);
//continue handling new window