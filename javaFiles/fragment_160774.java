public boolean addItem (Item item) {
    // Rename loop variable
    for (int x = 0; x < items.length; x++) {
        if (items[x] == null) {
            // Asign the incoming item to items array in case this position is empty
            items[x] = item;
            return true;
        }
    }
    return false;
}