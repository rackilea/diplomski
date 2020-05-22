{
    // ...
    float speed = (float) SpeedDouble;
    if(speed > 1 || speed < -1) {
        commandSender.sendMessage("You have specified an argument out of range!");
        return;
    }
    playerToSetFlySpeed.setFlySpeed(speed);
}