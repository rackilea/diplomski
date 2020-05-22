import java.util.List;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSearchWD {
public WebDriver driver = null;
public String baseUrl;

@Test
public void testFlightSearchWD() throws InterruptedException {
    driver = new FirefoxDriver();
    driver.get("https://www.findmyfare.com/");
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement from1 = wait.until(ExpectedConditions
            .presenceOfElementLocated(By.id("from_1")));
    from1.click();
    from1.clear();
    from1.sendKeys("AKL");
    from1.sendKeys(Keys.ENTER);
    driver.findElement(By.id("to_1")).click();
    WebElement cleartext1 = driver.findElement(By.id("to_1"));
    cleartext1.clear();
    WebElement ToCity = driver.findElement(By.id("to_1"));
    ToCity.sendKeys("CMB");
    ToCity.sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    driver.findElement(By.xpath(".//*[@id='trip_types']")).click();
    driver.findElement(By.id("date_1")).click();
    List<WebElement> total_date = driver
            .findElements(By
                    .xpath("//div[@class='panel-body']/div[@class='pull-left col-md-6 pull-left-first']/table[1]//td"));
    int total_date_size = total_date.size();
    for (int i = 0; i < total_date_size; i++) {
        String date = total_date.get(i).getText();
        if (date.equalsIgnoreCase("20")) {
            total_date.get(i).click();
            break;
        }
    }
    driver.findElement(By.id("date_2")).click();
    List<WebElement> total_date1 = driver
            .findElements(By
                    .xpath("//div[@class='panel-body']/div[@class='pull-left col-md-6 pull-left-first']/table[1]//td"));
    int total_date_size1 = total_date1.size();
    for (int i = 0; i < total_date_size1; i++) {
        String date1 = total_date1.get(i).getText();
        if (date1.equalsIgnoreCase("25")) {
            total_date1.get(i).click();
            break;
        }
    }
    WebElement ClickTravellers = driver.findElement(By.id("PopS"));
    ClickTravellers.click();
    addAdults();
    addChildren();
    addInfant();

    WebElement clickSearch = driver.findElement(By
            .id("search_flight_submit"));
    clickSearch.click();

}

private void addAdults() {
    while (true) {
        WebElement popOverBtnGrp = driver
                .findElement(By
                        .xpath("//div[@class='btn-group col-xs-12 col-md-12 col-sm-12']"));
        if (popOverBtnGrp.isDisplayed()) {
            try {
                WebElement NoOfTravellers = driver
                        .findElement(By
                                .xpath("//button[@class='btn add_people  ripple-effect btn-default btn-sm col-xs-2 col-md-4 col-sm-4']"));
                for (int i = 0; i < 1; i++) {
                    NoOfTravellers.click();
                }
                break;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}

private void addChildren() {
    while (true) {
        WebElement popOverBtnGrp = driver
                .findElement(By
                        .xpath("//div[@class='btn-group col-xs-12 col-md-12 col-sm-12']"));
        if (popOverBtnGrp.isDisplayed()) {
            try {
                WebElement NoOfTravellers = driver
                        .findElement(By
                                .xpath("//button[@class=' add_people btn btn-default btn-sm  ripple-effect col-xs-2 col-md-4 col-sm-4' and @data-id='childrens']"));
                for (int i = 0; i < 1; i++) {
                    NoOfTravellers.click();
                }

                break;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

        }

    }

}

private void addInfant() {
    while (true) {
        WebElement popOverBtnGrp = driver
                .findElement(By
                        .xpath("//div[@class='btn-group col-xs-12 col-md-12 col-sm-12']"));
        if (popOverBtnGrp.isDisplayed()) {
            try {
                WebElement NoOfTravellers = driver
                        .findElement(By
                                .xpath("//button[@class='add_people btn btn-default btn-sm   ripple-effect col-xs-2 col-md-4 col-sm-4' and @data-id='infants']"));
                for (int i = 0; i < 1; i++) {
                    NoOfTravellers.click();
                }

                break;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

        }

    }

}

}