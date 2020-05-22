private void orButtonActionPerformed(java.awt.event.ActionEventevt) {
    final int caretPosition = inputTextField.getCaretPosition();
    String currentText = inputTextField.getText();
    String newText = currentText.substring(0, caretPosition) + 
    "∨" + currentText.substring(caretPosition, currentText.length());

    inputTextField.setText(newText);
    inputTextField.requestFocus();

    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            inputTextField.setCaretPosition(caretPosition);
        }
    });
}