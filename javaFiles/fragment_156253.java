rect.setOnMousePressed((MouseEvent me) -> {
        System.out.println("PRESSED_" + Double.toString(rect.getX()));
    });

    rect.setOnMouseReleased((MouseEvent me) -> {
        System.out.println("RELEASE_" + Double.toString(rect.getX()));
    });

    rect.setOnMouseDragged((MouseEvent me) ->{
        double diffX = me.getX() - rect.getWidth() / 2;
        double diffY = me.getY() - rect.getHeight() / 2;
        System.out.println("SET_" + Double.toString(rect.getX()));
        rect.setX(diffX);
        rect.setY(diffY);
    });