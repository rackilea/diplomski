double deltaX = player.getX() - point.getX();
double deltaY = player.getY() - point.getY();
double magnitude = Math.sqrt(deltaX*deltaX + deltaY*deltaY);

// It's possible for magnitude to be zero (cursor is over the person)
// Decide what you want the default direction to be to handle that case
double xVelocity = 1;
double yVelocity = 0;
if (magnitude != 0) {
    xVelocity = deltaX / magnitude;
    yVelocity = deltaY / magnitude;
}