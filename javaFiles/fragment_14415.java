private int explore(Ident item, int xcoord, int ycoord) {
    int counter = 0;

    Queue<Point> stack = Collections.asLifoQueue(new ArrayDeque<Point>());
    stack.add(new Point(xcoord, ycoord));

    while (!stack.isEmpty()) {
        Point point = stack.remove();
        xcoord = point.x;
        ycoord = point.y;

        if (!item.equals(map[xcoord][ycoord])) {
            continue;
        }

        ++counter;
        map[xcoord][ycoord] = null;
        item.translate(xcoord, ycoord);

        for (int y = -1; y <= 1; y++)
            for (int x = -1; x <= 1; x++) {
                 int sumX = x + xcoord;
                 int sumY = y + ycoord;
                 if (
                     !(x == 0 && y == 0) &&
                     0 <= sumX && sumX < map.length &&
                     0 <= sumY && sumY < map[0].length
                 ) {
                     stack.add(new Point(sumX, sumY));
                 }
            }
        }
    }
    return counter;
}