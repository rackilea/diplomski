public void searchFlights() {
    actions(from,"Chennai");
    actions(to,"Madurai");
    actions(date,"25/08/2018");
    driver.findElement(date).sendKeys(Keys.TAB);
    selection(adults,"2");
    selection(childerns,"3");
    selection(infants,"1");
    driver.findElement(search).click();
    WebDriverWait wait= new WebDriverWait(driver,20);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='vendor']/a")));

    coupon =driver.findElements(By.xpath("//ul[@class='listView flights']/li/table/tbody/tr/td/span"));
    airName=driver.findElements(By.xpath("//ul[@class='listView flights']/li/table/tbody/tr/th/small"));
    departure=driver.findElements(By.xpath("//ul[@class='listView flights']/li/table/tbody/tr/th[@class='depart']"));
    arrival=driver.findElements(By.xpath("//ul[@class='listView flights']/li/table/tbody/tr/th[@class='arrive']"));
    travelTime=driver.findElements(By.xpath("//ul[@class='listView flights']/li/table/tbody/tr/th[@class='duration']"));
    ticketFare=driver.findElements(By.xpath("//ul[@class='listView flights']/li/table/tbody/tr/th[@class='price']"));


    System.out.println(airlineNames(coupon));
    System.out.println(airlineNames(airName));
    System.out.println(airlineNames(departure));
    System.out.println(airlineNames(arrival));
    System.out.println(airlineNames(travelTime));
    System.out.println(airlineNames(ticketFare));


}