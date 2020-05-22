centerX = window.width / 2;
centerY = window.height / 2;



deltaX = e.getX() - centerX;
deltaY = e.getY() - centerY;

scale = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)) / speed;

tempObject.setVelY(deltaY / scale);
tempObject.setVelX(deltaX / scale);