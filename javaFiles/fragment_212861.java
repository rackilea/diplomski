List<WebElement> listaPret = driver.findElements(By.className("pret-mare"));

 for (int i = 0; i < listaPret.size(); i++){
      double price = Double.parseDouble(listaPret.get(i).getText()); 
      assertThat(price).isBetween(50.000,80.000);
 }