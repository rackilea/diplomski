download.setOnMousePressed(new EventHandler<MouseEvent>(){
    @Override
    public void handle(MouseEvent event) {
        if(!Dialog.isOpen) Dialog.wait("Processing, please wait...");
    }
});
download.setOnMouseReleased(new EventHandler<MouseEvent>(){
    @Override
    public void handle(MouseEvent event) {
        doDownload();
    }
});