@RunWith(Parameterized.class)
public class LoginTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
         { "user1", "password" }, 
         { "user2", "password" } //...
    });
}

private String username, password;

public LoginTest(String username, String password) {
     this.username = username;
     this.password = password;
}

@Test
public void fb() {
    // most of it won't change, except:
    driver.findElement(By.name("email")).sendKeys(username);
    driver.findElement(By.name("pass")).sendKeys(password);
    // ...
}