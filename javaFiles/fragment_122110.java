pane.removeAll();
Box vert = Box.createVerticalBox();
Box top = Box.createHorizontalBox();
top.add(Box.createHorizontalGlue());
top.add(new JLabel("Top Label"));
top.add(new JButton("Top Button"));
vert.add(top);
vert.add(tabbed);
pane.add(vert);
....