public class Triangle implements Shape {
    private static double total_area = 0;
    private static double total_perim = 0;

    private double length;
    private double x,y;
    private boolean rotate;
    private boolean fill;

    private int[] xPoints;
    private int[] yPoints;

    public Triangle(Triangle triangle) {
        this.length = triangle.length;
        this.x = triangle.x;
        this.y = triangle.y;
        this.rotate = triangle.rotate;
        this.fill = triangle.fill;

        this.xPoints = xPoints != null ? Arrays.copyOf(xPoints, xPoints.length) : null;
        this.yPoints = yPoints != null ? Arrays.copyOf(yPoints, yPoints.length) : null;
    }
 }