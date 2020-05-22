GridBagConstraints noFill = new GridBagConstraints();
noFill.anchor = GridBagConstraints.WEST;
noFill.fill = GridBagConstraints.NONE;

GridBagConstraints horizontalFill = new GridBagConstraints();
horizontalFill.anchor = GridBagConstraints.WEST;
horizontalFill.fill = GridBagConstraints.HORIZONTAL;    

panel.add(new JLabel("Left Aligned"), noFill);
panel.add(Box.createHorizontalGlue(), horizontalFill);