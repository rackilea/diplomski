Platform.setImplicitExit(false);

primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
    @Override
    public void handle(WindowEvent event) {
        event.consume();
    }
});