Boolean fun(WebDriver d)
    {
        JavascriptExecutor j = (JavascriptExecutor) d;
        return (Boolean) j.executeScript("return document.readyState").toString().equals("");
    }
ExpectedCondition<Boolean> cd = this::fun;