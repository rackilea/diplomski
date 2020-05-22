// Won't say anything about how much these values make sense
static final int[][] directions = {
    {3,  6, 0},
    {5, -1, 2}, // -1 for "no direction", feel free to replace
    {4,  7, 1}
};

public int direction(int x, int y) {
    x = (x < 0) ? 0 : ((x > 0) ? 2 : 1);
    y = (y < 0) ? 0 : ((y > 0) ? 2 : 1);

    return directions[y][x];
}