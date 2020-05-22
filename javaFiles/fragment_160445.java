public void actionPerformed(ActionEvent e) {
  if (e.getActionCommand().equalsIgnoreCase("grid")) {
     gridPane.setGridOn(!gridPane.isGridOn());
  }

  if (e.getActionCommand().equalsIgnoreCase("square")) {
     gridPane.setSqaureOn(!gridPane.isSquareOn());
  }
}