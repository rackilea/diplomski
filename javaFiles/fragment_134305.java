protected WebElement findElement(By criteria) {
    try {
        WebElementHandler webElementHander = new WebElementHandler(seleniumWebDriver.findElement(criteria));
        return (WebElement) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{WebElement.class}, webElementHander);
    } catch (NoSuchElementException e) {
        logger.error("Could not find " + criteria + " on page " + seleniumWebDriver.getCurrentUrl());
        throw e;
    }
}

private class WebElementHandler implements InvocationHandler {
    private WebElement proxiedElement;

    private WebElementHandler(WebElement proxiedElement) {
        this.proxiedElement = proxiedElement;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("clear")) {
            Keys[] keys = new Keys[proxiedElement.getAttribute("value").length()];
            for (int i = 0; i < keys.length; i++)
                keys[i] = Keys.BACK_SPACE;

            proxiedElement.sendKeys(Keys.chord(keys));
            return null;
        }
        return method.invoke(proxiedElement, args);
    }
}