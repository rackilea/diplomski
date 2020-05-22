//initiate jradiobutton arraylist (this will be a field at top of class)
buttons = new ArrayList<JRadioButtons>();

//Create buttons with a listener attached
JRadioButton b1 = new JRadioButton("RadioButton One");
b1.setActionListener(myActionListener);
b1.setActionCommand("select");
buttons.add(b1);

//Add rest of buttons in the same way
JRadioButton b2...

//Add the radio buttons to your panel and such