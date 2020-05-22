int tX = target.x;
int tY = target.y;
float speed = getOwner.getMoveSpeed();
float dX = tX - oX;
float dY = tY - oY;
float dist = Math.sqrt(dX * dX + dY * dY);
float sX = speed * dX / dist;
float sY = speed * dY / dist;

getOwner().addX((int) (sX + 0.5));
getOwner().addY((int) (sY + 0.5));