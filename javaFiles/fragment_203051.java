// ItemBean item = new ItemBean(); // You don't need this one.
 while (rs.next()) {
   ItemBean item = new ItemBean(); // Instantiate a new ItemBean, don't update ONE.
   item.setItemName(rs.getString("itemname"));
   item.setItemPrice(rs.getDouble("itemprice"));
   item.setTransactionTime(rs.getString("transactiontime"));
   itemList.add(item); // Add the item to the List.
 }