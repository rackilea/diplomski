private void FloodFill(Bitmap bmp, Point pt, int targetColor, int replacementColor) 
{
    Queue<Point> q = new LinkedList<Point>();
    q.add(pt);
    while (q.size() > 0) {
        Point n = q.poll();
        if (bmp.getPixel(n.x, n.y) != targetColor)
            continue;

        Point w = n, e = new Point(n.x + 1, n.y);
        while ((w.x > 0) && (bmp.getPixel(w.x, w.y) == targetColor)) {
            bmp.setPixel(w.x, w.y, replacementColor);
            if ((w.y > 0) && (bmp.getPixel(w.x, w.y - 1) == targetColor))
                q.add(new Point(w.x, w.y - 1));
            if ((w.y < bmp.getHeight() - 1)
                    && (bmp.getPixel(w.x, w.y + 1) == targetColor))
                q.add(new Point(w.x, w.y + 1));
            w.x--;
        }
        while ((e.x < bmp.getWidth() - 1)
                && (bmp.getPixel(e.x, e.y) == targetColor)) {
            bmp.setPixel(e.x, e.y, replacementColor);

            if ((e.y > 0) && (bmp.getPixel(e.x, e.y - 1) == targetColor))
                q.add(new Point(e.x, e.y - 1));
            if ((e.y < bmp.getHeight() - 1)
                    && (bmp.getPixel(e.x, e.y + 1) == targetColor))
                q.add(new Point(e.x, e.y + 1));
            e.x++;
        }
    }
}