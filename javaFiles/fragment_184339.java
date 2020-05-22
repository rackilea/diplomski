static int countPaths(String... grid) {
    int[] paths = new int[grid[0].length() + 1];
    paths[grid[0].length() - 1] = 1;
    for (int y = grid.length - 1; y >= 0; y--)
        for (int x = grid[0].length() - 1; x >= 0; x--)
            paths[x] = (grid[y].charAt(x) != '0' ? 0 : paths[x] + paths[x + 1]);
    return paths[0];
}