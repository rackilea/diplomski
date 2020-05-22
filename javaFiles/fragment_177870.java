chatBox = new JTextArea();   
chatBox.setEditable(false);    

scroll = new JScrollPane(chatBox, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
scroll.setBounds(17,40,593,226);
contentPane.add(scroll);