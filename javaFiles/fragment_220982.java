public static WebElement switchToIFrameWithElement(WebDriver driver, By element) {
    driver.switchTo().defaultContent();

    try {
        if (driver.findElement(element).isDisplayed()) ;
        {
            System.out.println("Element is displayed on main page");
        }
    } catch (Exception continueFlow) {
        List<WebElement> frames = driver.findElements(By.cssSelector("iframe"));
        for (WebElement frame : frames) {
            driver.switchTo().defaultContent();
            System.out.println("going back to main page");
            try {
                driver.switchTo().frame(frame);
                System.out.println("switched to next frame: " + frame);
                if (driver.findElement(element).isDisplayed()) {
                    System.out.println("element is found in frame: " + frame);
                    break;
                }
            } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException ignored) {
            }
        }
    }  System.out.println("returned element succesfully");
    return driver.findElement(element);
}