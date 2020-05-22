Map<Coin, LineItem> map = new HashMap<Coin, LineItem>();
for (Coin aCoin : coins) {
    LineItem anItem = map.get(aCoin);
    if(anItem == null) {
        map.put(aCoin, new LineItem(aCoin, 1));
    } else {
        anItem.setQuantity(anItem.getQuantity()+1);
    }
}
itemsList.addAll(map.values());