@RunWith(SpringRunner.class)
@SpringBootTest
public class GoogleSearchPageTraditionalSeleniumTests extends BaseSeleniumTests {

    @Test
    public void getSearchPage() {
        this.driver.get("https://www.google.com");
        WebElement element = this.driver.findElement(By.name("q"));
        assertNotNull(element);
    }

}