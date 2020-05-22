public class Vertex {

    public static enum Shape {
        CONCAVE, CONVEX, UNDEFINED
    }

    private Shape shape; // the instance variable
    private int[] point;

    public Vertex () {
        point = new int[] {0, 0};
        shape = Shape.UNDEFINED;
    }

    public Shape getShape () {
        return shape;
    }

    public void setShape (Shape shape) {
        this.shape = shape;
    }
}