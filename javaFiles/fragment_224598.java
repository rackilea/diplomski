public RadioButtonEditor(JCheckBox checkBox)
{
  super(checkBox);
  ActionListener editingListener = new ActionListener()
  {
    public void actionPerformed(ActionEvent e)
    {
      // editing is now complete - don't wait for focus to be lost
      // this will switch back to showing renderer
      //    and fire the event to tablemodellisteners
      stopCellEditing();
    }
  };
  btnVA.addActionListener(editingListener);
  btnUIT.addActionListener(editingListener);
  btnAAN.addActionListener(editingListener);
}