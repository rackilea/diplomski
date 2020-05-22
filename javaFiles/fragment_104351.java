for (Coin aCoin : coins) {
    boolean done = false;
    for (Iterator<LineItem> it = itemList.iterator();it.hasNext() && !done) {
        LineItem currentItem = it.next()
        Coin currentCoin = currentItem.getCoin();
        int currentQuantity = currentItem.getQuantity();
        if (currentCoin.equals(aCoin)) {
            currentItem.setQuantity(currentQuantity + 1);
            done = true;
        }
    }
    if(!done) {
        LineItem anItem = new LineItem(aCoin, 1);
        itemsList.add(anItem);
    }
}