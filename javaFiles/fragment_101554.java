Point firstPoint = new Point(100, 200);
Point secondPoint = new Point(100, 400);
Point middlePoint = new Point(firstPoint.x,
        firstPoint.y + 0.5 * (secondPoint.y -  firstPoint.y));

Scalar lineColor = new Scalar(255, 0, 0, 255);
int lineWidth = 3;

Scalar textColor = new Scalar(255, 0, 0, 255);

Imgproc.line(sourceMat, firstPoint, secondPoint, lineColor, lineWidth);
Imgproc.putText(sourceMat, " Text" , middlePoint,
        Core.FONT_HERSHEY_PLAIN, 1.5 , textColor);