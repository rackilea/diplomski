private WebDriver driver;

public void login(String username, String password) {
    driver.findElement(By.name("email")).sendKeys(username);
    driver.findElement(By.name("pass")).sendKeys(password);
    driver.findElement(By.name("login")).click();
}

// Move code to init driver to run before every test
@Before
public void initDriver() {
    FirefoxProfile ffprofile = new FirefoxProfile();
    ffprofile.setPreference("general.useragent.override", "iPhone"); //this will change the user agent which will open mobile browser
    driver = new FirefoxDriver(ffprofile);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().setSize(new Dimension(400, 800)); //just to change the window size so that it will look like mobile ;)
    driver.get("http://www.fb.com/");
}

@Test
public void fb1() {
    login("user1", "password");
}

@Test
public void fb2() {
    login("user2", "password");
}

// etc