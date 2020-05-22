public void run() {
    circle = createCircle();

    frame = new JFrame("Circle Sprite");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    drawingPanel = new DrawingPanel(circle);
    frame.add(drawingPanel);

    frame.pack();
    frame.setLocationByPlatform(true);
    frame.setVisible(true);

    new Thread(new RandomDraw(drawingPanel)).start();
}