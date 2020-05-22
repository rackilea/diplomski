while(clickMore == true) {
    List<WebElement> button = driver.findElements(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]/div/div[2]/div[2]/div/div[4]/button"));
    if(button.size() > 0) {
        button.get(0).click();
        Thread.sleep(4000);
    }
    else clickMore = false;
}

WebElement present = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]/div/div[2]/div[2]/div/div[3]/div/table/tbody"));
List<WebElement> list = present.findElements(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]/div/div[2]/div[2]/div/div[3]/div/table/tbody/tr"));
System.out.println("Total Number of TR: " + list.size());