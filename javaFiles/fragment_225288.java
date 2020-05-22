public SVGCanvasDemo(JFrame frame) {
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add("Center", svgCanvas);
    frame.setVisible(true);
    svgCanvas.setURI("file:/c:/files/hungryminds/rectangles.svg");
}