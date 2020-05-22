static void checkItems(TreeItem item, boolean checked) {
     item.setGrayed(false);
     item.setChecked(checked);
     TreeItem[] items = item.getItems();
     for (int i = 0; i < items.length; i++) {
        checkItems(items[i], checked);
     }
}