By loadingIndicator = By.xpath("//span[@class='loading']");
boolean loadingFinished = false;

while (!loadingFinished) 
{
    System.out.println("is loading");

    // attempt to find the loading indicator, catch exception if it is not found
    try {
        WebElement loader = driver.findElement(loadingIndicator);

        // check isDisplayed(), set found to true
        if (!loader.isDisplayed()) loadingFinished = true;

        // handle exception where loadmask no longer exists
    } catch (NoSuchElementException e) {
        loadingFinished = true;
        e.printStackTrace();
    }
}