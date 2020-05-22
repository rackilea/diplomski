JScrollPane scrollPane = new JScrollPane(table);
frame.add(scrollPane, BorderLayout.CENTER);

Box east = Box.CreateVerticalBox();
east.add(Box.createVerticalGlue());
east.add(button);
frame.add(east, BorderLayout.LINE_END);