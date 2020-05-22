TreeItem<String> item = searchItem(someString, root);
if (item != null) {
    item.setExpanded(false);
    item = item.getParent();
    while (item != null) {
        item.setExpanded(true);
        item = item.getParent();
    }
}