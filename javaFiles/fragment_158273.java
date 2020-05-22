private Pane createGrid(int numColumns, int numRows) {

    Pane view = new Pane();

    for (int x = 0 ; x <= numColumns ; x++) {
        Line line = new Line();
        line.startXProperty().bind(view.widthProperty().multiply(x).divide(numColumns));
        line.endXProperty().bind(line.startXProperty());
        line.setStartY(0);
        line.endYProperty().bind(view.heightProperty());
        view.getChildren().add(line);
    }

    for (int y = 0 ; y <= numRows ; y++) {
        Line line = new Line();
        line.startYProperty().bind(view.heightProperty().multiply(y).divide(numRows));
        line.endYProperty().bind(line.startYProperty());
        line.setStartX(0);
        line.endXProperty().bind(view.widthProperty());
        view.getChildren().add(line);
    }

    view.setPrefSize(20*numColumns, 20*numRows);
    return view ;
}