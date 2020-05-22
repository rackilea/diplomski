ListIterator itr = stock.listIterator();
while(itr.hasNext())
 {
    StockItem item = (StockItem)itr.next();
    if(item.getitemID() == itemID)
    {
                    item.setPrice(price);
         break;
    }
  }