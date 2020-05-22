tree.addListener(SWT.Selection, new Listener() {
      public void handleEvent(Event event) {
       if (event.detail == SWT.CHECK) {
        TreeItem item = (TreeItem) event.item;
        boolean checked = item.getChecked();
        checkItems(item, checked);
        }
     }
});