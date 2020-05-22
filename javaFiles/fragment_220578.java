void work(Color color, Function<Integer, Integer> algorithm) {
    int prevY = 0;
    StdDraw.setPenColor(color);
    for (int i = 1; i <= N; i++) {
        int x = i;
        int y = algorithm.apply(i);
        int prevX = i - 1;
        StdDraw.setPenRadius(lineRadius);
        StdDraw.line(prevX, prevY, x, y);
        StdDraw.setPenRadius(pointRadius);
        StdDraw.point(x, y);
        prevY = y;
    }
}