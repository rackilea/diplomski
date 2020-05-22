WebDriverWait wait = new WebDriverWait(driver, LOADING_TIMEOUT);

    WebElement webElement;
    try {
        webElement = wait.until(elementToBeClickable(By.id(id)));
    } catch (TimeoutException ex) {
        // Close loading window
        return;
    }

    webElement.click();