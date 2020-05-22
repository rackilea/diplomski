int deltaX = bullet.endpos.x - bullet.startx; //this code is when I create a new bullet
int deltaY = bullet.endpos.y - bullet.starty;
double radius = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
double normalizedDeltaX = deltaX / radius;
double normalizedDeltaY = deltaY / radius;
speed = 5.0;

bullet.x -= /*maybe your error is here, and there should be += as you need to increment coordinates, not decrement*/ speed * normalizedDeltaX;
bullet.y -= /*the same thing here*/ speed * normalizedDeltaY;