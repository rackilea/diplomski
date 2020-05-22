List<WebElement> clientidtxt = driver.findElements(By.xpath("//label[contains(.,'Client ID')]/following::input[@id='CId']"));
for (WebElement webElement1 : clientidtxt)
{
        webElement1.sendKeys(Keys.ENTER); // What's this for? Can this be removed?
        webElement1.sendKeys(uuid);
        System.out.println(webElement1.getText()); // if webElement1 is an INPUT, this needs to be webElement1.getAttribute("value") to return what the INPUT contains
}