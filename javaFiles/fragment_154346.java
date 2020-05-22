List<WebElement> elements = driver.findElements(By.cssSelector("#dataTableAdvertisers a"));

for (WebElement element: elements){
    if (!element.getText().contains("RealMedia")){
        //select the item in the table
        driver.findElement(By.xpath(PvtConstants.READ_ADVERTISRERS_ADVERTISER_IDS)).click();

        //click the delete button
        driver.findElement(By.xpath(".//*[@id='deleteAdv']")).click();
    }
}