import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Main {

public static void main(String args[]) {
    play(new FirefoxDriver());
    play(new SafariDriver());
    System.setProperty("webdriver.chrome.driver", "/Users/Apple/Documents/chromedriver");
    play(new ChromeDriver());
}

public static void play(WebDriver driver) {
    driver.get("http://gabrielecirulli.github.io/2048");
    driver.findElement(By.className("restart-button")).click();
    String script = "fireKey(arguments[0]);\n"
            + "function fireKey(arrow)\n"
            + "{\n"
            + "    var key;\n"
            + "    switch (arrow.toLowerCase())\n"
            + "    {\n"
            + "        case \"left\":\n"
            + "            key = 37;\n"
            + "            break;\n"
            + "        case \"right\":\n"
            + "            key = 39;\n"
            + "            break;\n"
            + "        case \"up\":\n"
            + "            key = 38;\n"
            + "            break;\n"
            + "        case \"down\":\n"
            + "            key = 40;\n"
            + "            break;\n"
            + "    }\n"
            + "    if (document.createEventObject)\n"
            + "    {\n"
            + "        var eventObj = document.createEventObject();\n"
            + "        eventObj.keyCode = key;\n"
            + "        document.documentElement.fireEvent(\"onkeydown\", eventObj);\n"
            + "    } else if (document.createEvent)\n"
            + "    {\n"
            + "        var eventObj = document.createEvent(\"Events\");\n"
            + "        eventObj.initEvent(\"keydown\", true, true);\n"
            + "        eventObj.which = key;\n"
            + "        document.documentElement.dispatchEvent(eventObj);\n"
            + "    }\n"
            + "} ";

    JavascriptExecutor js = (JavascriptExecutor) driver;
    //use left,right,up,down for arrow keys
    for (int i = 0; i < 50; i++) {
        js.executeScript(script, "left");
        js.executeScript(script, "right");
        js.executeScript(script, "up");
        js.executeScript(script, "down");
    }
    System.out.println("Score :" + driver.findElement(By.className("score-container")).getText());
    driver.quit();
}
}