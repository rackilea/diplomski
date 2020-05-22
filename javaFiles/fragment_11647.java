Pane chartContent = (Pane)baseChart.lookup(".chart-content");
chartContent.setOnMouseClicked(event ->  {
    if(event.getX() >= chartBackground.getBoundsInParent().getMinX() &&
                event.getX() <= chartBackground.getBoundsInParent().getMaxX() &&
                event.getY() >= chartBackground.getBoundsInParent().getMinY() &&
                event.getY() <= chartBackground.getBoundsInParent().getMaxY()) {
        chartContent.getChildren().addAll(new EditableDraggableText(event.getX(), event.getY()));
    }
});