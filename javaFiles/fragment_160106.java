alert.showingProperty().addListener((src, ov, nv) -> {
    double x = alert.getX();
    double y = alert.getY();
    double w = alert.getWidth();
    double h = alert.getHeight();

    // as example just adjust if location top/left is off 
    // production must cope with bottom/right off as well, obviously 
    if (x < 0) {
        alert.setWidth(w + x);
        alert.setY(0);
    }
    if (y <0) {
        alert.setHeight(h + y);
        alert.setY(0);
    }

});
alert.showAndWait();