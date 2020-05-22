public void init() {
  cup = getImage(getDocumentBase(), "cup.gif");
  Canvas myCanvas = new Canvas();

  Keyarray[0] = new Button("Up");
  Keyarray[1] = new Button("Left");
  Keyarray[2] = new Button("Down");
  Keyarray[3] = new Button("Right");
  Keyarray[4] = new Button("Center");
  setBackground(Color.BLUE);

  // I just removed Panel frame and added components directly to applet
  setLayout(new BorderLayout());
  add(myCanvas, BorderLayout.CENTER);
  myCanvas.setBackground(Color.red);
  Keypad.setLayout(new BorderLayout());
  add(Keypad, BorderLayout.SOUTH);
  // Keypad.setLayout(new BorderLayout());

  Keypad.add(Keyarray[0], BorderLayout.NORTH);
  Keypad.add(Keyarray[1], BorderLayout.WEST);
  Keypad.add(Keyarray[2], BorderLayout.SOUTH);
  Keypad.add(Keyarray[3], BorderLayout.EAST);
  Keypad.add(Keyarray[4], BorderLayout.CENTER);

  Keyarray[0].addActionListener(this);
  Keyarray[1].addActionListener(this);
  Keyarray[2].addActionListener(this);
  Keyarray[3].addActionListener(this);
  Keyarray[4].addActionListener(this);

}// end of method init