//...Where initialization occurs...
JFrame frame = new JFrame("Test");
JPanel panel = new JPanel(new BorderLayout());

//...Create a variety of components here...

//Create the component that will have the initial focus.
JButton button = new JButton("I am first");
panel.add(button);
frame.getContentPane().add(panel);  //Add it to the panel

frame.pack();  //Realize the components.
//This button will have the initial focus.
button.requestFocusInWindow(); 
frame.setVisible(true); //Display the window.