public static <T extends LoginPage> WebDriver getDriver(Class<T> loginClass)
{
    if (WebDriverUtil.hasQuit()) {
        log.debug("Creating new instance of driver");
        BaseTest.init();

        browser = region.getBrowser().getName();

        driver = WebDriverUtil.initDriver(browser, baseURL);
        wait = new WebDriverWait(driver, DEFAULT_TIMEOUT/1000 );
        SeleniumUtil.waitForPageLoaded(driver,DEFAULT_TIMEOUT);

        handleLogin(driver, loginClass);
    }       

    return driver;
}

private static <T extends LoginPage> void handleLogin(WebDriver driver, Class<T> loginClass)
{
    if(loginClass != null)
    {
        try {
            Constructor<T> constructor = loginClass.getDeclaredConstructor(WebDriver.class);
            try {
                T loginObj = constructor.newInstance(driver);
                loginObj.signIn(user, pass);
            } catch (InstantiationException | IllegalAccessException
                    | IllegalArgumentException
                    | InvocationTargetException e) {
                log.warn("Error instantiating object for class: " + loginClass.toString());
            }
        } catch (NoSuchMethodException e) {
            log.warn("No constructor that takes WebDriver is present on class: " + loginClass.toString());
            log.trace(e);
        } catch (SecurityException e) {
            log.warn("SecurityException present on class: " + loginClass.toString());
            log.trace(e);
        }
    }
}