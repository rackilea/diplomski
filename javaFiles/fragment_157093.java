private static Selenium selenium;

@BeforeClass
public static void beforeClass() throws Exception {
    selenium = new DefaultSelenium("localhost", 4444, "*firefox","https://www.google.com/");
    selenium.start();
}

@Test
public void testGoogle() throws Exception {
    selenium.open("https://www.google.com");
}

@Test
public void testYahoo() throws Exception {
    selenium.open("https://www.yahoo.com");
}