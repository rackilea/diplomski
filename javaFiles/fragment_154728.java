int offset = textArea.getCaretPosition();
Rectangle location = textArea.modelToView(offset);
JList list = new JList(...);
list.setVisibleRowCount(...);
JScrollPane scrollPane = new JScrollPane(list);
scrollPane.setSize(scrollPane.getPreferredSize();
scrollPane.setLocation(location.x, location.y);
textArea.add(scrollPane);