public void moveForward() {
     ySpeed += 0.01 * Math.sin(Math.toRadians(targetAngle));
     xSpeed += 0.01 * Math.cos(Math.toRadians(targetAngle));
     double currentSpeed = Math.sqrt(xTempSpeed * xTempSpeed + yTempSpeed * yTempSpeed);
     if (currentSpeed > maxSpeed) {
         //the resulting speed is allways <= maxspeed (normed to that)
         ySpeed *= maxSpeed/currentSpeed;
         xSpeed *= maxSpeed/currentSpeed;
 }