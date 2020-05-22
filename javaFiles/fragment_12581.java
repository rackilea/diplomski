float pointX = p.getX();
float pointY = p.getY();

//rotation as radians
float cos = (float) Math.cos(rotation);
float sin = (float) Math.sin(rotation);

float newPointX = centerX +(pointX-centerX) * cos + (pointY-centerY) * sin;
float newPointY = centerY +(pointY-centerY) * cos - (pointX-centerX) * sin;

p.setPos(newPointX, newPointY);