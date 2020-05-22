JPanel panel = new JPanel();
panel.setLayout(new BorderLayout());  //give your JPanel a BorderLayout

JTextArea text = new JTextArea(); 
JScrollPane scroll = new JScrollPane(text); //place the JTextArea in a scroll pane
panel.add(scroll, BorderLayout.CENTER); //add the JScrollPane to the panel
// CENTER will use up all available space