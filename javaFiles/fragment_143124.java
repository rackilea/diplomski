UISession session = RWT.getUISession( display );

Thread thread = new Thread( this::calcualteItemsInShoppingCart );
thread.start();

void calculateItemsInShopingCart() {
  SoppingCart cart = SingletonUtil.getUniqueInstance( ShoppingCart.class, session );
  // use cart...
}