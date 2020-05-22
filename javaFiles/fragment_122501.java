scrollpane = new JScrollPane(textpane);
panel.add(scrollpane, BorderLayout.CENTER);
textpane.setSize(size);
scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
panel.add(textpane);
frame.add(panel);