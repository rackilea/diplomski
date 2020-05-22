@Test(priority = 1)
public void searchHPComputers() throws InterruptedException
{

    Thread.sleep(2000);
    WebDriverWait wait1 = new WebDriverWait(driver, 40);
    wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='Newest First']")));
    Thread.sleep(1000);
    List<WebElement> element =  driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
    List<WebElement> elementLink = driver.findElements(By.xpath("//div[@class='_3wU53n']"));

    int largestPrice =0, elementIndex =0, i=0;

    for(WebElement web : element)
    {
        String amount =  web.getText();
        int length = amount.length();
        String price = amount.substring(1, length);
        price = price.replaceAll(",", "");
        int priceInt = Integer.parseInt(price);
        System.out.println("Amount : "+ priceInt);
        Thread.sleep(1000);

        if(priceInt > largestPrice) {

            largestPrice = priceInt;

            elementIndex = i;
        }

        i++;
    }


    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("arguments[0].scrollIntoView(true);", elementLink.get(elementIndex-1));

    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(elementLink.get(elementIndex)));

    elementLink.get(elementIndex).click();
}