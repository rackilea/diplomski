TreeItem items[] = tree.getItems();
//Print all items recursively
printItems(items);
...
void printItems(TreeItem items[]) {
    for (TreeItem i: items) {
        System.out.println(i.getText(2));
        //Check if expanded
        if (!i.getExpanded())
            continue;
        printItems(i.getItems());
    }
}