List<WebElement> links = driver.findElements(By.xpath("//ul[@role='listbox']//span"));
    Set<String> resultsSet = new HashSet<String>();
    for (int i=0; i<links.size();i++){
          String value = links.get(i).getText();
          resultsSet.add(value);
    }
    System.out.println(resultsSet.toString());