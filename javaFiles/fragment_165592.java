import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
// we need the above using statements to use WebDriverWait and ExpectedConditions

// first wait for number of windows to be 2:
WebDriverWait wait = new WebDriverWait(browser, 10);
wait.until(ExpectedConditions.numberOfWindowsToBe(2)));

// switch to a new window
String window2 = (String) AllWindowHandles.toArray()[1];
scenario.write("Switching to Child (Viewer) window = "+ AllWindowHandles.toArray()[1]);
browser.switchTo().window(window2);

// wait on some element on the page to be fully loaded
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("outerDiv")));