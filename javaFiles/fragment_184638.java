import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

class NewThread implements Runnable {
static WebDriver driver = new FirefoxDriver();
Thread t;

NewThread() {
try {
Thread.sleep(10000);
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

// Create a new, second thread
t = new Thread(this, "Demo Thread");
System.out.println("Child thread: " + t);
// Start the thread
t.start();
}

// This is the entry point for the second thread.
public void run() {
try {

System.out.println("This thread has got the control now");
Thread.sleep(5000);

} catch (InterruptedException e) {
System.out.println("Child interrupted.");
}

for (String handle : driver.getWindowHandles()) {
driver.switchTo().window(handle);
}

String nextHandle = driver.getWindowHandle();
System.out.println("nextHnadle" + nextHandle);

try {
Thread.sleep(4000);
} catch (InterruptedException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}

driver.findElement(By.id("foo")).clear();
driver.findElement(By.id("foo")).sendKeys("4");
try {
Thread.sleep(2000);
} catch (InterruptedException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}

driver.findElement(By.linkText("link")).click();
try {
Thread.sleep(4000);
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

driver.quit();
System.out.println("Exiting child thread.");
}

// execution will start from here
public static void main(String args[]) throws InterruptedException {
try {
// open the webpage
driver.get("https://developer.mozilla.org/samples/domref/showModalDialog.html");

// get window handle
String currenthandle = driver.getWindowHandle();
System.out.println("currenthandle" + currenthandle);

//start a new thread
new NewThread();

// click on the button to open model window dialog
driver.findElement(By.tagName("input")).click();

} catch (Exception e) {
System.out.println("Main thread interrupted.");
}
System.out.println("Main thread exiting.");
}

}