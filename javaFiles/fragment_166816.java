List<WebElement> links = driver.find elements(By.cssSelector('#tblPriorEventsBody td a'));

Iterator<WebElement> iter = links.iterator();

while(iter.hasNext()) {
    WebElement we = iter.next();

    if (we.text.equals("whatever") {
        we.click;
    // do something in else perhaps
    }
}