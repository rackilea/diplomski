import net.lightbody.bmp.proxy.ProxyServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProxyServerBasicAutorizationTest {

    private ProxyServer server;
    private WebDriver driver;

    @Before
    public void startProxy() throws Exception {
        server = new ProxyServer(4444);
        server.start();
        server.autoBasicAuthorization("", "username", "password");
        Proxy proxy = server.seleniumProxy();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        driver = new FirefoxDriver(capabilities);
    }

    @Test
    public void testAccessProtectedSite() throws Exception {
        driver.get("https://example.com");
        driver.findElement(By.className("sign-out"));
    }

    @After
    public void stopProxyServer() throws Exception {
        driver.quit();
        server.stop();
    }
}