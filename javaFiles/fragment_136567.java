public void startApp() {
    TestCanvas theCanvas= new TestCanvas();
    display = Display.getDisplay(this);
    display.setCurrent(theCanvas);
    new Thread(theCanvas).start(); // add here and...
}
//...
public TestCanvas() {
    super(false);
    setFullScreenMode(true);
    width = getWidth();
    height = getHeight();
    // ...and remove here
    // Thread thisThread = new Thread(this);
    // thisThread.start();
}