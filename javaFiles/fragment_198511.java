Panel findPanel = new Panel();
TextField find_field = new TextField(); 
find_field.setPreferredSize(new Dimension(150,25));
Button find = new Button("Find");
findPanel.add(find_field);
findPanel.add(find);
notepad.add(findPanel, BorderLayout.EAST);
notepad.validate();