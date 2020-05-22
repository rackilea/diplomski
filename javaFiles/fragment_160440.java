pane.setOnMouseClicked( e -> {

    if (e.getButton() == MouseButton.PRIMARY) {

       Circle circle = new Circle(e.getX(), e.getY(), 5) ;
       circles.add(circle);
       pane.getChildren().add(circle);
       circle.setStroke(Color.BLACK);
       circle.setFill(Color.WHITE);

       // not sure what index is for. Looks like it would always be
       // equal to circles.size()
       index++;

    }
});