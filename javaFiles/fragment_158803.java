List<String> specificationItems = new ArrayList<String>();
List<String> specificationValues = new ArrayList<String>();
List<WebElement> all_specificationItems = driver.findElements(By.xpath("//div[@class='specificationList']/ul[@class='inner']//li[@class='specificationItem']/dl/dt[@class='icon']/span[starts-with(@id,'Body_ContentPlaceHolderContent_ContentPlaceHolderContent_VehicleFeatures_FeatureList_FeatureText_')]"));
List<WebElement> all_specificationValues = driver.findElements(By.xpath("//div[@class='specificationList']/ul[@class='inner']//li[@class='specificationItem']/dl//span[@class='valueContent']"));
int size = all_specificationItems.size();
for(WebElement ele:all_specificationItems)
    specificationItems.add(ele.getAttribute("innerHTML"));
for(WebElement elem:all_specificationValues)
    specificationValues.add(elem.getAttribute("innerHTML"));
for(int i=0;i<size;i++)
    System.out.println(specificationItems.get(i) + " has a value of " + specificationValues.get(i));