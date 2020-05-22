public void actionPerformed(ActionEvent evt) {

  // .. whatever code is needed for the button

  // and then disable the button pressed
  ((AbstractButton)evt.getSource).setEnabled(false);
}