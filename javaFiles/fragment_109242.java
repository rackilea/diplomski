if (firstStick == null) {
    firstStick = new Stick(Integer.parseInt(response));
    prevStick = firstStick;                
} else {
    currentStick = new Stick(Integer.parseInt(response));
    prevStick.setNextStick(currentStick);
    prevStick = currentStick;
}