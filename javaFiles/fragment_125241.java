// Here, you create a local copy of the CardLayout
CardLayout cl = new CardLayout();
// But here it seems you are creating a class instance of the setPanel...
setPanel =  new JPanel();//panel to store the other panels
setPanel.setLayout(cl);//create the different set of windows

JButton enter = new JButton("Enter");
JPanel loginPanel = new JPanel();

loginPanel.add(enter);