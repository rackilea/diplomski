editor.jtbDefaultOperation.addActionListener(e -> {
  System.out.println("jtbDefaultOperation" + editor.getData().index);
  Container c = SwingUtilities.getAncestorOfClass(JComboBox.class, editor);
  if (c instanceof JComboBox) {
    JComboBox<?> combo = (JComboBox<?>) c;
    TheModel o = (TheModel) combo.getItemAt(editor.getData().index);
    o.setDefaultOperation(((JCheckBox) e.getSource()).isSelected());
  }
});