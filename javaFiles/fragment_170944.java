image2.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        mouseEvent.consume();
        System.out.println("Image! " + mouseEvent.getTarget());
    }
});