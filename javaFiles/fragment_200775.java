public class QuadTree {
    private QuadTree[] children;
    private double x;
    private double y;
    private double size;

    public QuadTree(double x, double y, double size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void divide() {
        if (children == null) {
            children = new QuadTree[4];
            double s = 0.5 * size;
            children[0] = new QuadTree(x, y, s);
            children[1] = new QuadTree(x + s, y, s);
            children[2] = new QuadTree(x, y + s, s);
            children[3] = new QuadTree(x + s, y + s, s);
        }
    }

    public QuadTree getChild(int index) {
        if (children == null)
            return null;
        else
            return children[index];
    }