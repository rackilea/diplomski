for (int = 0 ; i < items.length; ++i) {
    Item item = items[i]; 
    if (i < 27 && i > -1) {
        // do something here like item.getRawSlot();
    }
    // another example of something you could now do that you
    // couldn't do using for-each
    items[i] = new Item(...);
}