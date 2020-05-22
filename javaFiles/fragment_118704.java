private NutPad() {
    setLayout(new BorderLayout());
    add(makeScrollPane(), BorderLayout.CENTER);
}

private JScrollPane makeScrollPane() {
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);

    return scrollPane;
}