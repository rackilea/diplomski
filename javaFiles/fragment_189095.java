public static void checkPendingRequests(FirefoxDriver driver) {
    int timeoutInSeconds = 5;
    try {
        if (driver instanceof JavascriptExecutor) {
            JavascriptExecutor jsDriver = (JavascriptExecutor)driver;

            for (int i = 0; i< timeoutInSeconds; i++) 
            {
                Object numberOfAjaxConnections = jsDriver.executeScript("return window.openHTTPs");
                // return should be a number
                if (numberOfAjaxConnections instanceof Long) {
                    Long n = (Long)numberOfAjaxConnections;
                    System.out.println("Number of active calls: " + n);
                    if (n.longValue() == 0L)  break;
                } else{
                    // If it's not a number, the page might have been freshly loaded indicating the monkey
                    // patch is replaced or we haven't yet done the patch.
                    monkeyPatchXMLHttpRequest(driver);
                }
                Thread.sleep(1000);
            }
        }
        else {
           System.out.println("Web driver: " + driver + " cannot execute javascript");
        }
    }
    catch (InterruptedException e) {
        System.out.println(e);
    }    
}



public static void monkeyPatchXMLHttpRequest(FirefoxDriver driver) {
    try {
        if (driver instanceof JavascriptExecutor) {
            JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
            Object numberOfAjaxConnections = jsDriver.executeScript("return window.openHTTPs");
            if (numberOfAjaxConnections instanceof Long) {
                return;
            }
            String script = "  (function() {" +
                "var oldOpen = XMLHttpRequest.prototype.open;" +
                "window.openHTTPs = 0;" +
                "XMLHttpRequest.prototype.open = function(method, url, async, user, pass) {" +
                "window.openHTTPs++;" +
                "this.addEventListener('readystatechange', function() {" +
                "if(this.readyState == 4) {" +
                "window.openHTTPs--;" +
                "}" +
                "}, false);" +
                "oldOpen.call(this, method, url, async, user, pass);" +
                "}" +
                "})();";
            jsDriver.executeScript(script);
        }
        else {
           System.out.println("Web driver: " + driver + " cannot execute javascript");
        }
    }
    catch (Exception e) {
        System.out.println(e);
    }
}