javax.swing.Box bottomBox = Box.createHorizontalBox();
bottom = new JPanel();
bottomBox.add(bottom);
bottom.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
bottom.add(label4);
temperature2.setMaximumSize(temperature2.getPreferredSize());
bottom.add(temperature2);
...
container.add( bottomBox, BorderLayout.SOUTH );