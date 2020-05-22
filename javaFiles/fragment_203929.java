@Before
public void before() {
    driver = new ChromeDriver();
}

@After
public void tearDown()
{
    driver.quit();
}

@Test
public void signInFacebook(String link) throws InterruptedException {
    //Do 1 test here
}