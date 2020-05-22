private void OpenButtons(int x, int y) {
    Queue<Point> toOpen = new LinkedBlockingQueue<>();
    toOpen.add(new Point(x, y));
    array[x][y] = -1;
    while (!toOpen.isEmpty()) {
        Point p = toOpen.poll();
        x = p.x;
        y = p.y;
        for (int k = -1; k < 2; k++) {
            for (int k1 = 1; k1 >= -1; k1--) {
                if (x + k >= 0 && x + k < array.length && y - k1 >= 0
                        && y - k1 < array[x + k].length)
                    if (array[x + k][y - k1] == 0) {
                        array[x + k][y - k1] = -1;
                        toOpen.add(new Point(x + k, y - k1));
                    }
            }
        }
    }
}