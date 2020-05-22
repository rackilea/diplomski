//Create a JFrame and add the ScrollPane to it. 
  JFrame frame = new JFrame("JScrollPane Test");
  frame.getContentPane().setLayout(new GridBagLayout()); //Remove this line here and it works exactly how I want it to.
  GridBagConstraints c = new GridBagConstraints();
  c.fill = GridBagConstraints.BOTH;
  c.weightx = 1.0;
  c.weighty = 1.0;
  frame.getContentPane().add( tablePane, c );