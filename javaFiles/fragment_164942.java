JPanel top = new JPanel();
top.add(...);
JTextArea textArea = new JTextArea(5, 20);
JScrollPane scrollPane = new JScrollPane( textArea );
JPanel main = new JPanel( new BorderLayout() );
main.add(top, BorderLayout.PAGE_START);
main.add(scrollPane, BorderLayout.CENTER);