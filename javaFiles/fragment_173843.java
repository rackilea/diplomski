public void updateMessage(DroneModel model) {
  pitchValue.setText(String.valueOf(model.getPitch()));
  rollValue.setText(String.valueOf(model.getRoll()));
  yawValue.setText(String.valueOf(model.getYaw()));
  thrustValue.setText(String.valueOf(model.getThrust()));
}