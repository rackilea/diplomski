public StockClient[] getStocks() throws NotLoggedInException {
  checkLoggedIn();
  PersistenceManager pm = getPersistenceManager();
  List<StockClient> stockclients = new ArrayList<StockClient>();
  try {
    Query q = pm.newQuery(Stock.class, "user == u");
    q.declareParameters("com.google.appengine.api.users.User u");
    q.setOrdering("createDate");
    List<Stock> stocks = (List<Stock>) q.execute(getUser());
    for (Stock stock : stocks)
    {
       stockclients.add(new StockClient(stock.getId(), stock.getSymbol(), stock.getCreateDate()));
    }
  } finally {
    pm.close();
  }
  return (StockClient[]) stockclients.toArray(new StockClient[0]);
}