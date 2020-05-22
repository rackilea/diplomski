package com.stackoverflow;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.services.Init;

public class Issue3 extends Init {

    @Test
    public void solutionOfIssue() throws InterruptedException {

        /*
         * The best thing is to first assert & verify that, that particular
         * element is present or not. if you see function
         * assertAndVerifyElement() --- it continuously checks for element for 5
         * secs and then assert it accordingly.
         */

        assertAndVerifyElement(By.cssSelector("button.btn.btn-default"));
        getWebDriver().findElement(By.cssSelector("button.btn.btn-default")).click();

        assertAndVerifyElement(By.xpath("//div[@id='content']/div/form"));
        getWebDriver().findElement(By.xpath("//div[@id='content']/div/form")).click();

        assertAndVerifyElement(By.linkText("Order"));
        getWebDriver().findElement(By.linkText("Order")).click();

    }

    public void assertAndVerifyElement(By element) throws InterruptedException {
        boolean isPresent = false;

        for (int i = 0; i < 5; i++) {
            try {
                if (getWebDriver().findElement(element) != null) {
                    isPresent = true;
                    break;
                }
            } catch (Exception e) {
                // System.out.println(e.getLocalizedMessage());
                Thread.sleep(1000);
            }
        }
        Assert.assertTrue(isPresent, "\"" + element + "\" is not present.");
    }

}