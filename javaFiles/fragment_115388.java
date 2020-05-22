setLayout( new BorderLayout() );

JPanel buttonsPanel = new JPanel();
buttonsPanel.add(run);
buttonsPane.add((open);
buttonsPanel.add(exit);
add(buttonsPanel, BorderLayout.PAGE_START);

JTextArea textArea = new JTextArea(10, 30); // give text area a default preferred size
add(new JScrollPane(textArea), BorderLayout.CENTER);