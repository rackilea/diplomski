public static void awb_origin_dest(String airport_name){
    boolean found = false; // this will check if airport was found
    for(int i=0;i<50;i++){

        List<WebElement> ele=driver.findElements(By.tagName("td"));
        for(int j=0;j<ele.size();j++) {
            String listOfValues = ele.get(j).getText();
            //System.out.println(listOfValues);
            if (listOfValues.contains(airport_name)) {
                Actions actions = new Actions(driver);
                actions.doubleClick(ele.get(j)).perform();
                found = true; // catch that airport was found
                break; // break inner loop
            } else {
                continue;
            }
        }
        if (found){ // if found, break the outer loop
            break; // break outer loop
        }
        driver.findElement(By.id("f2ListEnquiry_table_next")).click();
    }
}