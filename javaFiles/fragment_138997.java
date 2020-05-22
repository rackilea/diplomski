JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("popup_window = window.open('https://www.facebook.com')");

    Thread.sleep(5000);

    js.executeScript("popup_window.close()");