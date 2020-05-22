if (currentAngle - targetAngle == 0) return;

if (Math.abs(currentAngle - targetAngle) < 180) {
    // Rotate current directly towards target.
    if (currentAngle < targetAngle) currentAngle++;
    else currentAngle--;
} else {
    // Rotate the other direction towards target.
    if (currentAngle < targetAngle) currentAngle--;
    else currentAngle++;
}
currentAngle = ((currentAngle % 360) + 360) % 360;