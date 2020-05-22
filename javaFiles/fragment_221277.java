for (int i=0; i < list.size(); i++) {
    if (list.get(i).length() == 2) {
        list.add(i, "**");
        i++; // Do skip the item
    }
}