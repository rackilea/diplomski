import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;

...

File phantomJSBinary = new File("path" + File.separator + "to" + File.separator + "phantomjs");
DesiredCapabilities caps = new DesiredCapabilities();
caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomJSBinary.getAbsolutePath());
WebDriver driver = new PhantomJSDriver(caps);

...