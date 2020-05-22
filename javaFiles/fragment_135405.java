public static Rect getBottomMostRect(List<Rect> rects) {
    Rect bottomMostRect = null;

    if (rects != null && rects.size() >= 1) {
        Rect rect;
        double minY;
        int ixMinY = 0;

        rect = rects.get(ixMinY);
        minY = rect.tl().y;

        for (int ix = 1; ix < rects.size(); ix++) {
            rect = rects.get(ix);
            if (rect.tl().y < minY) {
                minY = rect.tl().y;
                ixMinY = ix;
            }
        }

        bottomMostRect = rects.get(ixMinY);
    }

    return bottomMostRect;
}