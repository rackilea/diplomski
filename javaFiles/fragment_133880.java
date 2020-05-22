import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;    
import junit.framework.TestCase;

public class HelloSeleniumTest extends TestCase {

    private Selenium browser;

    public void setUp() {

        browser = new DefaultSelenium("localhost",

            4444, "*firefox", "http://www.google.com");

        browser.start();

    }



    public void testGoogle() {

        browser.open("http://www.google.com/webhp?hl=en");

        browser.type("q", "hello world");

        browser.click("btnG");

        browser.waitForPageToLoad("5000");

        assertEquals("hello world - Google Search", browser.getTitle());

    }



    public void tearDown() {

        browser.stop();

    }

}