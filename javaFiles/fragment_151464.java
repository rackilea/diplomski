// Basic constraints...
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridwidth = GridBagConstraints.REMAINDER;
gbc.weightx = 1;
gbc.fill = GridBagConstraints.HORIZONTAL;

// Add your components...
add(panel, gbc);
//...

// Then add a fill component to push the layout to the top...
gbc.weighty = 1;
add(new JPanel(), gbc);
// You can use a constant value if you want, as it will be easier to remove
// so you can add new components to the end and re-add it when you're done