public static List<LocalStore> checkInStock(String gameTitle) {
   return checkInStock(new Game(gameTitle));
}

public static List<LocalStore> checkInStock(Game g) {
    List<LocalStores> stores = new ArrayList<LocalStores>();
    for (Map.Entry<LocalStore, HashMap<Game, AtomicInteger>> entry : inStock.entrySet()) {
      HashMap<Game, AtomicInteger> tmp = entry.getValue();
      AtomicInteger anInt = tmp.get(g);
      if (anInt != null && anInt.get() > 0) {
        stores.add(entry.getKey());
      }
    }
    return stores;
}