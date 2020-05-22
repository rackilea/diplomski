JScrollPane listPane = new JScrollPane();
pane.add(listPane, BorderLayout.CENTER);
listPane.setBackground(Color.LIGHT_GRAY);
listPane.setBorder(new EmptyBorder(0, 20, 0, 0));
listPane.setViewportView(fileList);
// removed add line