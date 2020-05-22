static boolean isInsideDiamond(int x, int y, int[] xs, int[] ys) {
    int minX = xs[0];
    int maxX = minX;
    int minY = ys[0];
    int maxY = minY;
    for (int i = 1; i < 4; ++i) {
        minX = Math.min(minX, xs[i]);
        maxX = Math.max(maxX, xs[i]);
        minY = Math.min(minY, ys[i]);
        maxY = Math.max(maxY, ys[i]);
    }

    int orgX = (minX + maxX) / 2;
    int orgY = (minY + maxY) / 2;
    int radX = (maxX - minX) / 2;
    int radY = (maxY - minY) / 2;

    return isInsideDiamond(x, y, orgX, orgY, radX, radY);
}

static boolean isInsideDiamond(int x, int y, int orgX, int orgY, int radX,
        int radY) {
    x -= orgX;
    x = Math.abs(x);
    y -= orgY;
    y = Math.abs(y);
    return x * radY + y * radX <= radX * radY;
}