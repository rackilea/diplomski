JFrame frame = new JFrame ("Test");
JTextArea textArea = new JTextArea ("Test");

JScrollPane scroll = new JScrollPane (textArea, 
   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

frame.add(scroll);
frame.setVisible (true);