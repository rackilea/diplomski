private void getPrice(String s) {
    Arrays.sort(products);  <--- sort products, but prices' indices remain unchanged
    int searchedProductIndex = Arrays.binarySearch(products, s);
    if (searchedProductIndex >= 0) {
      this.price = prices[searchedProductIndex];
      this.isValidOrder = true;
    } else {
      price = 0.0;
      isValidOrder = false;
      message = "**ERROR**: Invalid product name";
    }
  }    <--- closing curly bracket