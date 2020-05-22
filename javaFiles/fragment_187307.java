int x = 0;
    int y = 0;
    gridView.setOnMouseDragged((event) -> {
        if(x != 0){ //prevent from panning before values are initialized
            gridView.setTranslateX( gridView.getTranslateX() + limit(event.getX() - x, 25));
            gridView.setTranslateY( gridView.getTranslateY() + limit(event.getY() - y, 25));
        }
        x = (int)event.getX();
        y = (int)event.getY();
    });