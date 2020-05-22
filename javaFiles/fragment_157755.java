public void mousePressed(MouseEvent e) {
  if (e.getSource() == list) {
    return;
  }
  if (!SwingUtilities.isLeftMouseButton(e) || !comboBox.isEnabled())
    return;
  //...
  togglePopup();
}