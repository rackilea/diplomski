WebDriver driver = new FirefoxDriver();
driver.get("https://www.google.com");

Path cookiesFile = Paths.get("C:\\Temp\\cookies.txt");

// save the cookies to a file for the current domain
try (PrintWriter file = new PrintWriter(cookiesFile.toFile(), "UTF-8")) {
    for (Cookie c : driver.manage().getCookies()) {
        file.println(c.toString());
    }
}