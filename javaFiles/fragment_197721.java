g.setColor(Color.BLACK);
g.drawLine(startX, startY, endX, endY); //this is the original line

double length = Math.pow(Math.pow(startX-endX,2)+Math.pow(startY-endY,2),0.5);
double xChange = length * cos(Math.toRadians(angle));
double yChange = length * sin(Math.toRadians(angle));