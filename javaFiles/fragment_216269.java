// Step1: Go to watch page.
driver.get("https://www.o2.co.uk/shop/smartwatches/#sort=content.sorting.featured&page=1");

// Step2: Click on selected watch
WebElement element = driver.findElement(By.id("mywatch"));
driver.click(element);

// Step3: Get the status of watch
String item_status = driver.findElement(By.className("status-info")).getText();

//Step4: Navigate back if selected item is 'Out of Stock'
if(status.equals("Out of Stock")){
    driver.navigate().back();
}