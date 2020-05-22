public void setPlayer(Player player) {
  this.player = player;
  nameField.setText(player.getName());
  speedField.setText(String.valueOf(player.getSpeed()));
  strengthField.setText(String.valueOf(player.getStrength()));
}