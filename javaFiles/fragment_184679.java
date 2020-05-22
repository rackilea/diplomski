internalComboBox.addItemListener(e -> {
  if (e.getStateChange() == ItemEvent.SELECTED) {
    System.out.println("You chose ...");
    ((JComboBox) e.getSource()).getEditor().selectAll();
  }
});

class TheComboBoxEditor implements ComboBoxEditor {
  @Override
  public void selectAll() {
    editor.selectAll();
    // editor.requestFocus(); // <-- The focus moves from JTextField(jtfText) to JPanel(ThePanel).
  }