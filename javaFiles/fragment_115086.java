public void deleteItem(String itemID) 
    {
        ListIterator itr = stock.listIterator();
    while(itr.hasNext())
     {
         StockItem item = (StockItem)itr.next();
        if(item.getitemID() == itemID)
        {
            itr.remove(); // Removes last obejct returned by itr.next()
            break;
        }
     }
  }