if (menu.containsKey(item)) {
    Integer quanity = order.get(item);
    if (quanity == null) {
        quanity = 0;
    }
    quanity++;
    order.put(item, quantity);
}