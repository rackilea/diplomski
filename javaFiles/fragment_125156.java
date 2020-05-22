for (;;) {
  state = object.getCurrentState();
  if (object.updateValueAndStateIfStateDidntChange(state)) {
    break;
  }
}