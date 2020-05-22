void fillPanel() {
    panel = new JPanel();
    panel.setLayout(new BorderLayout(0, 0));
    final MyTextArea textArea;
    textArea = new MyTextArea();
    //textField should listen to customEventObject
    panel.add(textArea, BorderLayout.CENTER);
    textArea.setColumns(10);
    listeners.add(textArea);
}