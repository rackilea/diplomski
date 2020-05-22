WebDriverWait wait = new WebDriverWait(driver, LOADING_TIMEOUT);

    WebElement webElement;
    try {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        webElement = wait.until(elementToBeClickable(By.id(id)));
    } catch (TimeoutException ex) {
        // Delay any further interaction until the timeout has been restored
        webElement = null;
    } finally {
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT,
                TimeUnit.SECONDS);
    }

    if (webElement != null)
        webElement.click();
    else
        // Close loading window