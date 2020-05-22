// create the main JPanel
LayoutEg mainPanel = new LayoutEg();

// create a JFrame to put it in, although better to put into a JDialog
JFrame frame = new JFrame("Kilometer Converter");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// add the LayoutEg JPanel into the JFrame
frame.getContentPane().add(mainPanel);

// **** key method*** that tells the layout managers to work
frame.pack();

// center and display
frame.setLocationRelativeTo(null);
frame.setVisible(true);