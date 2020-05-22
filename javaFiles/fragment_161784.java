public static int[][] cut(int[][] source, int x, int y)
{
    return new int[][]{
        new int[]{ source[x][y], source[x + 1][y] },
        new int[]{ source[x][y + 1], source[x + 1][y + 1] }
    };
}