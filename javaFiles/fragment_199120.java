public void updateDisplay() {
    gridPane.getChildren().clear();
    for (int i = 0; i < nbColumn; i++) {
        for (int j = 0; j < nbRow; j++) {
            Rectangle rectangle = new Rectangle(100, 100);
            //Binding the fraction of the grid size to the width
            //and heightProperty of the child
            rectangle.widthProperty().bind(widthProperty.divide(nbColumn));
            rectangle.heightProperty().bind(heightProperty.divide(nbRow));
            gridPane.add(rectangle, i, j);
         }
    }
}