public final class SegmentAabbIntersector {

    private static final int INSIDE = 0x0000;
    private static final int LEFT = 0x0001;
    private static final int RIGHT = 0x0010;
    private static final int BOTTOM = 0x0100;
    private static final int TOP = 0x1000;

    // Cohen–Sutherland clipping algorithm (adjusted for our needs)
    public static boolean cohenSutherlandIntersection(float x1, float y1, float x2, float y2, Rectangle r, Vector2 intersection) {

        int regionCode1 = calculateRegionCode(x1, y1, r);
        int regionCode2 = calculateRegionCode(x2, y2, r);

        float xMin = r.x;
        float xMax = r.x + r.width;
        float yMin = r.y;
        float yMax = r.y + r.height;

        while (true) {
            if (regionCode1 == INSIDE) {
                intersection.x = x1;
                intersection.y = y1;
                return true;
            } else if ((regionCode1 & regionCode2) != 0) {
                return false;
            } else {
                float x = 0.0f;
                float y = 0.0f;

                if ((regionCode1 & TOP) != 0) {
                    x = x1 + (x2 - x1) / (y2 - y1) * (yMax - y1);
                    y = yMax;
                } else if ((regionCode1 & BOTTOM) != 0) {
                    x = x1 + (x2 - x1) / (y2 - y1) * (yMin - y1);
                    y = yMin;
                } else if ((regionCode1 & RIGHT) != 0) {
                    y = y1 + (y2 - y1) / (x2 - x1) * (xMax - x1);
                    x = xMax;
                } else if ((regionCode1 & LEFT) != 0) {
                    y = y1 + (y2 - y1) / (x2 - x1) * (xMin - x1);
                    x = xMin;
                }

                x1 = x;
                y1 = y;
                regionCode1 = calculateRegionCode(x1, y1, r);
            }
        }
    }

    private static int calculateRegionCode(double x, double y, Rectangle r) {
        int code = INSIDE;

        if (x < r.x) {
            code |= LEFT;
        } else if (x > r.x + r.width) {
            code |= RIGHT;
        }

        if (y < r.y) {
            code |= BOTTOM;
        } else if (y > r.y + r.height) {
            code |= TOP;
        }

        return code;
    }
}