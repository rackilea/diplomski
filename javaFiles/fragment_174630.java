public class AutoItBasicAutorizationTest {

    private final String username = "username";
    private final String password = "password";

    @Test
    public void testBasicAuthenticationFirefox() throws Exception {
        WebDriver driver = new FirefoxDriver();
        File autoIt = new File("src/test/resources/auth.exe");

        // run exe file with passing user credentials
        Process p = Runtime.getRuntime().exec(
                autoIt.getAbsolutePath() + " "
                                  + username + " " + password);

        driver.get("https://example.com");
        driver.findElement(By.className("sign-out"));
        driver.quit();
    }
}