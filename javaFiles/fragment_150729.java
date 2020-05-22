Rect2 rectA = new Rect2();
Rect2 rectB = new Rect2();

rectB.setMyColor(Color.BLUE);
rectB.setX(300);
rectB.setY(300);

// assuming that the class's constructor allows sizing parameters
DrawingPanel drawingPanel = new DrawingPanel(1000, 800);
drawingPanel.addRect2(rectA);
drawingPanel.addRect2(rectB);

JFrame frame = new JFrame("Main2");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().add(drawingPanel);
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);