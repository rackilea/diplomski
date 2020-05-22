// Creating the panel
JPanel lPanel = new JPanel();
//lPanel.setSize(1000, 1000); //default size, not needed anymore
lPanel.setLayout(new BoxLayout(lPanel, BoxLayout.PAGE_AXIS));

//Adding the content
lPanel.add(new JLabel("Blah"));
// etc...

//Adjust the panel to its preferred size
lPanel.setSize(lPanel.getPreferredSize());

//Call the layout method 
//(this will adjust the content components to their correct size and position)
lPanel.doLayout();