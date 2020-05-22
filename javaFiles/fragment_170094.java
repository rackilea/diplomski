driver.get("http://www.google.com");

driver.findElement(By.name("q")).sendKeys("Java");
Thread.sleep(1000);

List<WebElement> list = driver.findElements(By.xpath("//ul[@role ='listbox']//li"));
System.out.println("Total no of suggestions in search box :: " +list.size());

for(int i=0; i<list.size();i++) {
        System.out.println(list.get(i));

        if(list.get(i).getText().trim().contains("java interview questions") || list.get(i).getText().trim().equalsIgnoreCase("java interview questions")) {
        list.get(i).click();
        break;
    }
}