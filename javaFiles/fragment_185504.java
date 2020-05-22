double oldSpeedUp = 0;
boolean found = false;
while(!found && threadMultiplier < 16) {
    // ...
    found = Math.round(speedUp) == Math.round(oldSpeedUp);
    oldSpeedUp = speedUp;
}