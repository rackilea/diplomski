public class StockListImpl implements StockList {

   private List<StockItem> stockList = new LinkedList<StockItem>();

   public void addItem(StockItem item) {
         stockList.add(item);
   }

  //etc...