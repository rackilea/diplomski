public static void write(Map<Integer, Item> items, Map<Integer, Store> stores, List<Stock> stocks) {
    System.out.println();
    System.out.println("Inventory Report");
    System.out.println("----------------");

    for(Stock stock : stocks) { // <-- for all Stocks
        Store store = stores.get(stock.getStoreID()); // <-- get Store
        Item item = items.get(stock.getItemSKU());  // <-- get Item
        System.out.println(item.getDescription() + "is from store" + store.getId() + "in" + store.getCity()  + "and costs" + item.getPrice());
    }
}