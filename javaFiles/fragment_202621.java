public void upDatePlayerAttributes() {
  String name = nameField.getText();
  int strength = 0;
  try {
     strength = Integer.parseInt(strengthField.getText());
  } catch (NumberFormatException e) {
     // TODO: notify user that field was empty
  }
  int speed = 0;
  try {
     speed = Integer.parseInt(speedField.getText());
  } catch (NumberFormatException e) {
     // TODO: notify user that field was empty
  }

  player.setName(name);
  player.setSpeed(speed);
  player.setStrength(strength);
}