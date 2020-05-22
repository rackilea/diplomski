// Rectangle mainPanel = new Rectangle();

  JFrame frame = new JFrame("DrawRect");

  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  frame.getContentPane().add(this);  // ****** note change
  frame.pack();
  frame.setLocationByPlatform(true);
  frame.setVisible(true);
  frame.addKeyListener(listener);