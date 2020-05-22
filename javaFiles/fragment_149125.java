public class LineDemo {
    public static void main(String[] args) {
        System.out.println(containsLocation(50, 75, 50, 50, 50, 100));
    }

    public static boolean containsLocation(int x, int y, int x1, int y1, int x2, int y2) {
        double dy = y2 - y1;
        double dx = x2 - x1;
        double dist = Math.sqrt(dx*dx + dy*dy);

        double angle = Math.atan2(dy, dx);
        double cos = Math.cos(-angle);
        double sin = Math.sin(-angle);

        double xRot = (x - x1) * cos - (y - y1) * sin;
        double yRot = (x - x1) * sin + (y - y1) * cos;

        // Actually, I only rotated the mouse point, since
        // I can use the first point of the line and its
        // euclidian distance to know where the rotated
        // second point would end.

        if (0 <= xRot && xRot <= dist) {
            double tolerance = 3; // distance tolerance in pixels

            if (Math.abs(yRot) <= tolerance) {
                return true;
            }
        }

        return false;
    }
}