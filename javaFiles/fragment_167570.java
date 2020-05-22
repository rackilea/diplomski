int centerX = width / 2;
int centerY = height / 2;
double angle = Math.atan2(centerY - mouseY, centerX - mouseX) - Math.PI / 2;

((Graphics2D)g).rotate(angle, centerX, centerY);

g.fillRect(...); // draw your rectangle