tree.addSelectionListener(new SelectionAdapter() {
    @Override
    public void widgetSelected(SelectionEvent e) {

        // get the selected item
        TreeItem item = (TreeItem) e.item;

        if(item != null) {
           ...