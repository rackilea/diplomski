for (Iterator<Item> i = set.iterator(); i.hasNext();) {
    Item item = i.next();
    if (item.qualify()) {
        item.operate();
        i.remove();
    }
}