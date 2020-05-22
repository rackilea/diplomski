void addToMap(Games games, Store store, int value) {
    HashMap<Store,Integer> m = myMap.get(games);
    if (m == null) {
        m = new HashMap<Store,Integer>();
        myMap.put(games, m);
    }
    m.put(store, value);
}