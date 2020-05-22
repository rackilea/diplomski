public void addStock(String stock){
    try {
        isStockNameValid(stock);
        isStockExists(stock);
        controller.addStockToDb(stock);
   } catch(IllegalArgumentException exe) {

   }
}

public boolean isStockNameValid(stock) throws IllegalArgumentException {
      //check stock name is valid, if not
      throw new IllegalArgumentException("Stock Name already exists");
}

public boolean isStockExists(stock) throws IllegalArgumentException {
      //check stock exists, if not
      throw new IllegalArgumentException("Stock Name already exists");
}