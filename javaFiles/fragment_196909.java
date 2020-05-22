@Override
 public void actionPerformed(ActionEvent e) {
    // get the text
    JTextComponent textComp = (JTextComponent) e.getSource();
    String text = textComp.getText();

    // do what you want with text here

    // clear the text
    textComp.setText("");
 }