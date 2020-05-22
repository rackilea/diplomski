//setVisible(true); // don't do this until all components are added to the frame.
...
add(panel, BorderLayout.CENTER);
JPanel buttonPanel = new JPanel();
JButton button = new JButton("Button");
buttonPanel.add( button );
add(buttonPanel, BorderLayout.PAGE_END);
setVisible(true);