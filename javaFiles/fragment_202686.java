for (Item otherItem : map.values()) {
    if((otherItem.price <= item.price + 100)
            && (otherItem.price >= item.price - 100)) {
        otherItem.printItemDetails();
    }
}