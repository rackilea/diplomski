String baseWin = driver.getWindowHandle();
    //Some methods to open new window, e.g.
    driver.findElementBy("home-button").click();

    //loop through all open windows to find out the new window
    for(String winHandle : driver.getWindowHandles()){
        if(!winHandle.equals(baseWin)){
            driver.switchTo().window(winHandle);
            //your actions with the new window, e.g.
            String newURL = driver.getCurrentUrl();
        }
    }

    //switch back to the main window after your actions with the new window
    driver.close();
    driver.switchTo().window(baseWin);

    //let the driver focus on the base window again to continue your testing
    ((JavascriptExecutor) driver).executeScript("window.focus();");