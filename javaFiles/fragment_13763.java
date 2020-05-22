int mArrayLength = punkteX[0].length;
int iArrayLength = punkteX.length;
Point2D[] point2DArray = new Point2D[mArrayLength];
int p = 0;
for(int m = 0; m < mArrayLength; m++) {
    for(int i = 0; i < iArrayLength; i++) {
        point2DArray[p] = new Point2D(punkteX[i][m], punkteY[i][m]);
        p++;
    }
}

public class Point2D {
    private double[] punkteX;
    private double[] punkteY;

    public Point2D(double[] punkteX, double[] punkteY) {
        this.punkteX = punkteX;
        this.punkteY = punkteY;
    }

    public double[] getPunkteX() {
        return punkteX;
    }

    public double[] getPunkteY() {
        return punkteY;
    }
}