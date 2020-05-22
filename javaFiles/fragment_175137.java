//JPanel panel = new JPanel(new BorderLayout());  
setLayout( new BorderLayout() ):

...

//panel.add(statusBar, BorderLayout.NORTH);
//panel.add(panel2, BorderLayout.SOUTH);
add(statusBar, BorderLayout.NORTH);
add(panel2, BorderLayout.SOUTH);