// !! added
private void imgMousePressed(MouseEvent e) {
  String result = JOptionPane.showInputDialog(this,
        "Please enter name for this point on image:");
  if (result != null) {
     stringPointMap.put(result, e.getPoint());
     listDataModel.addElement(result);
  }
}