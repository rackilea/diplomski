private class KeyboardActionListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        try {
            JButton key = (JButton) e.getSource();
            textComponent.getDocument().insertString(textComponent.getCaretPosition(), key.getText(), null);
        } catch (BadLocationException ex) {
            Logger.getLogger(KeyboardDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}