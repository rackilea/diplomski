public void verifyBag(String[] goods) {
    actions.clickOn(By.xpath(bagLocator));
    List<WebElement> listItems = actions.driver.findElements(By.xpath(bagItems));
    List <String> actualItems = new ArrayList<String>();
    for(int i=0;i<listItems.size();i++)
    {
        actualItems.add(listItems.get(i).getAttribute("href"));
    }
    List<String> goodsList = new ArrayList(Arrays.asList(goods));
    goodsList.removeAll(actualItems);
    if(goodsList.size() == 0) {
        // All goods from provided goods list are also in actualItems
    }
    else {
        // Some items didn't match
    }