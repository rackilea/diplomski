public final class Program {

    public static void main(String[] args) {

        float radius = 5.0f;

        float x1 = -10.0f;
        float y1 = -10.0f;
        float x2 = 31.0f;
        float y2 = 13.0f;

        Rectangle r = new Rectangle(3.0f, 3.0f, 20.0f, 10.0f);
        Rectangle expandedR = new Rectangle(r.x - radius, r.y - radius, r.width + 2.0f * radius, r.height + 2.0f * radius);

        Vector2 intersection = new Vector2();

        boolean isIntersection = SegmentAabbIntersector.cohenSutherlandIntersection(x1, y1, x2, y2, expandedR, intersection);
        if (isIntersection) {
            boolean isLeft = intersection.x < r.x;
            boolean isRight = intersection.x > r.x + r.width;
            boolean isBottom = intersection.y < r.y;
            boolean isTop = intersection.y > r.y + r.height;

            String message = String.format("Intersection point: %s; isLeft: %b; isRight: %b; isBottom: %b, isTop: %b",
                    intersection, isLeft, isRight, isBottom, isTop);
            System.out.println(message);
        }

        long startTime = System.nanoTime();
        int numCalls = 10000000;
        for (int i = 0; i < numCalls; i++) {
            SegmentAabbIntersector.cohenSutherlandIntersection(x1, y1, x2, y2, expandedR, intersection);
        }
        long endTime = System.nanoTime();
        double durationMs = (endTime - startTime) / 1e6;

        System.out.println(String.format("Duration of %d calls: %f ms", numCalls, durationMs));
    }
}