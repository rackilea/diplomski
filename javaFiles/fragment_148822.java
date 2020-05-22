public class Range {

    private final Point a;
    private final Point b;
    private final ArrayList<Point> PointList;

    public Range(final Point a, final Point b) {
        int minColumn = (int) Math.min(a.getX(),b.getX());
        int minRow = (int) Math.min(a.getY(),b.getY());

        int maxColumn =(int)  Math.max(a.getX(),b.getX());
        int maxRow = (int) Math.max(a.getY(),b.getY());
        this.a = new Point(minColumn, minRow);
        this.b = new Point(maxColumn, maxRow);
        PointList = calcPoints();
    }

    private ArrayList<Point> calcPoints() {
        ArrayList<Point> list = new ArrayList<Point>();
        int minColumn = (int) a.getX();
        int minRow = (int) a.getY();
        int maxColumn = (int) b.getX();
        int maxRow = (int) b.getY();
        for (int i = minColumn; i < maxColumn; i++) {
            for (int j = minRow; j < maxRow; j++) {
                PointList.add(new Point(i, j));
            }
        }
        return list;
    }

    public ArrayList<Point> getPoints() {
        return PointList;
    }
}