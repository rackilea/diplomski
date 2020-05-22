package spreadsheet;

import java.awt.Point;
import java.util.ArrayList;

public class Range {

private final Point a;
private final Point b;
private final ArrayList<Point> PointList;

// Creates a new range, where it makes sure that the Points,
// appear in the right order, where the first Point is the Point
// of the upper left corner, and the second Point is the lower right corner.
public Range(final Point a, final Point b) {
    int minColumn = (int) Math.min(a.getX(),b.getX());
    int minRow = (int) Math.min(a.getY(),b.getY());

    int maxColumn =(int)  Math.max(a.getX(),b.getX());
    int maxRow = (int) Math.max(a.getY(),b.getY());
    this.a = new Point(minColumn, minRow);
    this.b = new Point(maxColumn, maxRow);
    PointList = new ArrayList<Point>();
}

public ArrayList<Point> getPoints() {
    int minColumn = (int) a.getX();
    int minRow = (int) a.getY();
    int maxColumn = (int) b.getX();
    int maxRow = (int) b.getY();
    for (int i = minColumn; i < maxColumn; i++) {
        for (int j = minRow; j < maxRow; j++) {
            PointList.add(new Point(i, j));
        }
    }
    return PointList;
}