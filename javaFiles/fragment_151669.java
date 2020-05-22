target.addDropListener(new DropTargetListener() {
    public void dragEnter(DropTargetEvent event) {
    }
    public void dragOver(DropTargetEvent event) {
    }
    public void dragOperationChanged(DropTargetEvent event) {
    }
    public void dragLeave(DropTargetEvent event) {
    }
    public void dropAccept(DropTargetEvent event) {
    }
    public void drop(DropTargetEvent event) {
        // do what ever you want...
        if (textTransfer.isSupportedType(event.currentDataType)) {
            String text = (String)event.data;
            TableItem item = new TableItem(dropTable, SWT.NONE);
            item.setText(text);
        }
        if (fileTransfer.isSupportedType(event.currentDataType)){
            String[] files = (String[])event.data;
            for (int i = 0; i < files.length; i++) {
                TableItem item = new TableItem(dropTable, SWT.NONE);
                item.setText(files[i]);
            }
        }
    }
});