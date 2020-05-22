Rectangle mainPanel = new Rectangle();  // ***** no!!! ****

  JFrame frame = new JFrame("DrawRect");

  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  frame.getContentPane().add(mainPanel);  // **** no ****
  frame.pack();
  frame.setLocationByPlatform(true);
  frame.setVisible(true);
  frame.addKeyListener(listener);