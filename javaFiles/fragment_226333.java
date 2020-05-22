int centerX = 0;
int centerY = 0;

int[] xPoints = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 };
int[] yPoints = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };

Graphics2D g2d = (Graphics2D) g;
GeneralPath star = new GeneralPath();
star.moveTo(xPoints[0] + centerX, yPoints[0] + centerY);

for (int count = 1; count < xPoints.length; count++)
    star.lineTo(xPoints[count] + centerX, yPoints[count] + centerY);
star.closePath();

g2d.setColor(color);
g2d.fill(star);