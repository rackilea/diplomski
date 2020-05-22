private void onDragDetected(MouseEvent event) {
    TreeCell<String> source = (TreeCell<String>) event.getSource();
    Dragboard db = source.startDragAndDrop(TransferMode.ANY);
    ClipboardContent content = new ClipboardContent();
    content.putString(source.getItem());
    db.setContent(content);
    event.consume();
}

private void onDragOver(DragEvent dragEvent) {
    Dragboard db = dragEvent.getDragboard();
    if (db.hasString()) {
        dragEvent.acceptTransferModes(TransferMode.COPY);
    }
    dragEvent.consume();
}

private void onDragDropped(DragEvent event) {
    Dragboard db = event.getDragboard();
    boolean success = false;
    if (db.hasString()) {
        System.out.println("Dropped: " + db.getString());
        success = true;
    }
    event.setDropCompleted(success);
    event.consume();
}