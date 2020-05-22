scrollPane.setOnDragEntered(new EventHandler<DragEvent>() {

    @Override
    public void handle(DragEvent event) {
    scrollPane.getScene().getWindow().requestFocus();
    scrollPane.requestFocus();
    event.consume();
    isDragging = true;

    }
});

scrollPane.setOnDragOver(new EventHandler<DragEvent>() {

    @Override
    public void handle(DragEvent event) {
    double windowHeight = scrollPane.getHeight();
    double topBar = (20*windowHeight)/100;
    double bottomBar = windowHeight - topBar;
    event.acceptTransferModes(TransferMode.LINK);
    if(event.getY() > 0 && event.getY() < topBar && scrollPane.getVvalue() > 0)
    scrollPane.setVvalue(scrollPane.getVvalue()-0.001);
    else if(event.getY() < windowHeight && event.getY() > bottomBar && scrollPane.getVvalue() < 1)
    scrollPane.setVvalue(scrollPane.getVvalue()+0.001);
    }

});

scrollPane.setOnDragExited(new EventHandler<Event>() {
    @Override
    public void handle(Event event) {
    isDragging = false;
    event.consume();
    }
});

scrollPane.setOnDragDropped(new EventHandler<Event>() {
    @Override
    public void handle(Event event) {
    isDragging = false;
    event.consume();
    }
});