List<WebElement> ShippingLabel = driver.findElements(By.xpath(" //label[contains(@class,'radio__label')]")); 
 List<WebElement> ShippingPrice = driver.findElements(By.xpath(" //label[contains(@class,'radio__label')]/following-sibling::span")); 

 for (int i = 0; i < ShippingLabel.size(); i++) {
     WebElement ele1 = ShippingLabel.get(i);
     WebElement ele2 = ShippingPrice.get(i);

     System.out.println(ele1.getText() + ":" + ele2.getText());
 }