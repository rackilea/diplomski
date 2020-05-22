public void insertUniqueItem(Item item) {
    if(!contains(item)) {
        cart.add(item);
    }
}

private boolean contains(Item item) {
    for(Item i : cart) {
        if(i.getName().equals(item.getName())) {
           return true;
        }
    }
    return false;
}