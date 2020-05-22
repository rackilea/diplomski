@Test
public void test() throws InterruptedException{

    driver.get("https://www.adidas.co.uk/on/demandware.store/Sites-adidas-GB-Site/en_GB/Cart-Show");
    JavascriptExecutor js=(JavascriptExecutor) driver;

    String link = "'http://www.example.com'"; // notice the extra ' inside the "

    //log the current value of 'action'
    js.executeScript("console.log(document.getElementsByClassName('co-formcontinueshopping')[0].action)");

    //change the value to the value hold by our link
    js.executeScript("document.getElementsByClassName('co-formcontinueshopping')[0].action=" + link);

    //log 'action' again
    js.executeScript("console.log(document.getElementsByClassName('co-formcontinueshopping')[0].action)");

    driver.quit();
}