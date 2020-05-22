JXPathContext context = JXPathContext.newContext(purchase);
OrderType orderDetail = (OrderType) context.getValue("orderDetail");
// equivalent to purchase.getOrderDetail()

for(Iterator iter = context.iterate("/orderDetail/items"); iter.hasNext()){
   Item i = (Item) iter.next();
   //...
}
// Assumes that OrderType has a items property
// List<Item> getItems()