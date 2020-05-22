@After
/**
 * Embed a screenshot in test report if test is marked as failed
 */
public void embedScreenshot(Scenario scenario) {

    if(scenario.isFailed()) {
    try {
         scenario.write("Current Page URL is " + driver.getCurrentUrl());
         //            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
        byte[] screenshot =  (TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    } catch (WebDriverException somePlatformsDontSupportScreenshots) {
        System.err.println(somePlatformsDontSupportScreenshots.getMessage());
    }

    }
    driver.quit();

}