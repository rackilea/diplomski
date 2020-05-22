@Override
    public void nativeMouseClicked(NativeMouseEvent nme) {
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nme) {
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nme) {
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent nme) {
    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent nme) {
    }

private void getMousePointColor() {
    int xLocation = MouseInfo.getPointerInfo().getLocation().x;
    int yLocation = MouseInfo.getPointerInfo().getLocation().y;
    System.out.println("------------------------------------------------------");

    Robot r;
    try {
        r = new Robot();
        System.out.println(r.getPixelColor(xLocation, yLocation));
    } catch (AWTException ex) {
        //TODO Exception handling
    }
    System.out.println("------------------------------------------------------");
}