private void addAt(JComponent component, GridBagConstraints constraints) {
  Coordinates coordinates = (Coordinates)component.getClientProperty("coords");
  int x = coordinates.getX();
  int y = coordinates.getY();

  // place it in the grid...
}