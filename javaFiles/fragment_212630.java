public void resize(Window win) {
    double x = win.getX();
    double y = win.getY();
    double width = win.getWidth();
    double height = win.getHeight();

    win.sizeToScene();

    win.setX(x + ((width - win.getWidth()) / 2));
    win.setY(y + ((height - win.getHeight()) / 2));
}