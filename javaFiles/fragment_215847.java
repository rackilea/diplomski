//JScrollPane logScrollPane = new JScrollPane();
logScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//logTextArea = new JTextArea("blah blah");
logTextArea = new JTextArea(5, 40);
logTextArea.setText("some text");
//logTextArea.setBounds(10, 10, 550, 300);
logTextArea.setEditable(false);
JScrollPane logScrollPane = new JScrollPane(logTextArea);