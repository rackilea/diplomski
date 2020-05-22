final int INFINITY = -1;
...
for (int k = 0 ; k != N ; k++) {
    for (int i = 0 ; i != N ; i++) {
        for (int j = 0 ; j != N ; j++) {
            if (g[i][k] == INFINITY || g[k][j] == INFINITY) continue;
            int total = g[i][k] + g[k][j];
            if (g[i][j] != INFINITY) {
                g[i][j] = Math.min(g[i][j], total);
            } else {
                g[i][j] = total;
            }
        }
    }
}