public void actionPerformed(ActionEvent evt) {
    String text = textField.getText();
    textArea.append(text + newline);
    textField.selectAll();

    //Make sure the new text is visible, even if there
    //was a selection in the text area.
    textArea.setCaretPosition(textArea.getDocument().getLength());
}