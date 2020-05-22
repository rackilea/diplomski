speed = 5; // "pixels" per frame
deltaX = destX - sourceX;
deltaY = destY - sourceY;
distance = sqrt(deltaX^2 + deltaY^2);

moveX = speed / distance * deltaX;
moveY = speed / distance * deltaY;

newX = sourceX + moveX;
newY = sourceY + moveY;