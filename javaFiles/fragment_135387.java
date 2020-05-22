public class PolygonImpl implements Polygon {

private double xSum=0;
private double ySum=0;
private Point[] pList;
private Point a;

    PolygonImpl(Point[] pList) {

        this.pList = pList.clone();

        for (int index = 0; index < pList.length; index++) {
           xSum += pList[index].getX();
           ySum += pList[index].getY();
        }
    }



    public Point getVertexAverage() {
         double xSum = 0;
         double ySum = 0;
        for (int index = 0; index < pList.length; index++) {
             xSum = xSum + pList[index].getX();
             ySum = ySum + pList[index].getY();
            }

        return new Point(xSum/getNumSides(), ySum/getNumSides());
    }

    public int getNumSides() {
        return pList.length;
    }

    public void move(Point c) {
        Point newCentroid = new Point(a.getX()+ c.getX(), a.getY() +c.getY());


    }

    public void scale(double factor) {
        for (int index = 0; index < pList.length; index++)
        {
            double x = pList[index].getX() *factor;
            double y = pList[index].getY() * factor;
            Point a = new Point(x,y);
            pList[index] = a;

        }
    }