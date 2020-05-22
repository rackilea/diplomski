pane.setOnMouseClicked(e -> {
        if (currentLine == null) {
            currentLine = new Line(e.getX(), e.getY(), e.getX(), e.getY());
            pane.getChildren().add(currentLine);
        } else {
            currentLine = null ;
        }
    });

    pane.setOnMouseMoved(e -> {
        if (currentLine != null) {
            currentLine.setEndX(e.getX());
            currentLine.setEndY(e.getY());
        }
    });