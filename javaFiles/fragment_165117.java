final Container filePane = SwingUtilities.getAncestorOfClass(sun.swing.FilePane.class, list);

filePane.addContainerListener(new ContainerAdapter() {

  @Override
  public void componentAdded(ContainerEvent e) {
    JTable table = SwingUtils.getDescendantOfType(JTable.class, fileChooser, "Enabled", true);
    if (table != null) {
      for (MouseListener l : table.getMouseListeners()) {
        if (l == listener) {
          return;
        }
      }          
      table.addMouseListener(listener);
    }
  }
});