/**
 * NoraUi is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 * 
 * @author Nicolas HALLOUIN
 * @author Stéphane GRILLON
 */
package com.github.noraui.bot;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.noraui.utils.Utilities.OperatingSystem;
import com.github.noraui.utils.Utilities.SystemArchitecture;

public class FirstSimpleBotWithZAPProxy {

    private static final Logger logger = LoggerFactory.getLogger(FirstSimpleBotWithZAPProxy.class);

    public static void main(String[] args) throws InterruptedException {

        Proxy proxy = new Proxy();
        proxy.setAutodetect(false);
        proxy.setHttpProxy("http://localhost:8092");

        final OperatingSystem currentOperatingSystem = OperatingSystem.getCurrentOperatingSystem();
        String pathWebdriver = String.format("src/test/resources/drivers/%s/googlechrome/%s/chromedriver%s", currentOperatingSystem.getOperatingSystemDir(),
                SystemArchitecture.getCurrentSystemArchitecture().getSystemArchitectureName(), currentOperatingSystem.getSuffixBinary());

        if (!new File(pathWebdriver).setExecutable(true)) {
            logger.error("ERROR when change setExecutable on " + pathWebdriver);
        }

        System.setProperty("webdriver.chrome.driver", pathWebdriver);
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setProxy(proxy);

        WebDriver driver = new ChromeDriver(chromeOptions);
        for (int i = 0; i < 6; i++) {
            driver.get("http://www.google.com/ncr");
            WebElement element = driver.findElement(By.name("q"));
            element.sendKeys("NoraUi");
            element.submit();
            logger.info(driver.getTitle());
            WebElement r = driver.findElement(By.xpath("//*[@id='resultStats']"));
            logger.info(r.getText());
        }
        driver.quit();
    }

}