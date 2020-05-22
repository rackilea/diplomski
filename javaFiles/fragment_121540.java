@When("search for product less than {int}")
   public static void search_for_product_less_than(Integer int1) {
        ShoppingPage myshopping = new ShoppingPage(driver);
        List<WebElement> SearchResults = myshopping.getSearchResult();
        for(WebElement myResult:SearchResults) {
            System.out.println(myResult.getText());
        }
    }