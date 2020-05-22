for (int column = 0; column < columns; column++) {
    for (List<String> list : dataSet) {
        Bag bag = new HashBag(); // I don't recall whether Apache Commons is generic
        bag.add(list.get(column));
        saveColumnStats(); // some method you would implement to save the data
    }
}