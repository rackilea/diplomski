public class LoadingDock {   // Context.
  private LoadStrategy ls;   // Strategy.

  public void setLoadStrategy(LoadStrategy ls) { ... }

  // Clients of LoadingDock use this method to do the relevant work, rather
  // than taking the responsibility of invoking the Strategy themselves.
  public void shipItems(List<ShippingItem> l) {
    // verify each item is properly packaged     \
    // ...                                        |  This code is complex and shouldn't be
    // verify all addresses are correct           |  subsumed into consumers of LoadingDock.
    // ...                                        |  Using a Context here is a win because
    // load containers onto available vehicle     |  now clients don't need to know how a
    Vehicle v = VehiclePool.fetch();        //    |  LoadingDock works or when to use a
    ls.load(v, l);                          //   /   LoadStrategy.
  }
}