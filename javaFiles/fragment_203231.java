WebElement pointer = driver.findElement(By.xpath("/html/body/div[4]/div/div/section/div[2]/div[3]/div/div[1]"));

// Generic path to simulate the change in the xpath for the elements of the following pattern:
// WebElement tag1 = pointer.findElement(By.xpath("./div[1]/div/div[2]/a"));
// WebElement tag2 = pointer.findElement(By.xpath("./div[2]/div/div[2]/a"));

List<WebElement> linksList = pointer.findElements(By.xpath("./div/div/div[2]/a")); 
    for (WebElement link : linksList) {
        System.out.println(link.getAttribute("href"));
    }