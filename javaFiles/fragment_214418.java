private CheckableItem[] createData(ArrayList<String> strs) {
    int n = strs.size();
    CheckableItem[] items = new CheckableItem[n];
    for (int i = 0; i < n; i++) {
        items[i] = new CheckableItem(strs.get(i));
    }
    return items;
}