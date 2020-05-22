hBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getTarget() == hBox) {
            System.out.println("hBox! " + mouseEvent.getTarget());
        } else {
            System.out.println("hBox Ignored! " + mouseEvent.getTarget());
        }
    }
});

image2.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("Image! " + mouseEvent.getTarget());
    }
});