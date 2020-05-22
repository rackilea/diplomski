List<WebElement> listaPret = driver.findElements(By.className("pret-mare"));

 for (WebElement item : listaPret) { 
      double price = Double.parseDouble(item.getText()); 
      assertThat(price).isBetween(50.000,80.000);
 }