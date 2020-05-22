FocusAdapter selectAllFocusAdapter = new FocusAdapter() {
  public void focusGained(FocusEvent e) {
    final JTextComponent tComponent = (JTextComponent) e.getSource();
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        tComponent.selectAll();
      }
    });
    tComponent.selectAll();
  }
};

myJTextField.addFocusListener(selectAllFocusAdapter);
otherJTextField.addFocusListener(selectAllFocusAdapter);
myTextArea.addFocusListener(selectAllFocusAdapter);