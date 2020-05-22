@Override
public void paintComponent(Graphics g) { // this is called by JFrame.paint()
    super.paintComponent(g);
    // ...
    jFrameDrawing.countDown();
}