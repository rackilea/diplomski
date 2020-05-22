public Long addStock(String symbol) throws NotLoggedInException {
  Stock stock = new Stock(getUser(), symbol);
  checkLoggedIn();
  PersistenceManager pm = getPersistenceManager();
  try {
    pm.makePersistent(stock);
  } finally {
    pm.close();
  }
  return stock.getId();
}