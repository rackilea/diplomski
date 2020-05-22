// Remove the global Webdriver instantiation

//Change return type from Object to WebDriver
public static WebDriver OpenApp (String Browser, String URL) {
    WebDriver driver = Func_LaunchBrowser(Browser);
    func_OpenURL(URL, driver); //pass in the driver as arg
    return driver;
}

//Refactor openUrl method to use the driver from arg
public static void func_OpenURL(String URL, WebDriver driver){...}