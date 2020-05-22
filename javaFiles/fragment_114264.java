while (true) {
    try {
        element.click();
    } catch (WebDriverException e) {
        // ignore
        Thread.sleep(millis);
    }