public static WebElement Email_Field(WebDriver driver) throws InterruptedException {

    WebElement element;

    (new WebDriverWait(driver, 30)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("alibaba-login-box"));

    element = driver.findElement(By.xpath("//input[@id='fm-login-id']"));

    while (!isDisplayed(element)) {
        Thread.sleep(3000);
        System.out.println("Element is not visible yet");
    }

    return element;
}