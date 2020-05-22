public void removeItemById(String itemId) {
   Iterator<StockItem> itr = stockList.listIterator();
   while(itr.hasNext()) {
       StockItem item = itr.next();
   if(item.getitemID().equals(itemId)) {
     itr.remove();
     break;
    }
   }
}