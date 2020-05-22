int minI = Math.max(x - 1, 0);
int maxI = Math.min(grid.length - 1, x + 1)
int minJ = Math.max(y - 1, 0);
int maxJ = Math.min(grid.length - 1, y + 1)

for (int i = minI; i <= maxI; i++) {
    for (int j = minJ; j <= maxJ; j++) {
        if (i != x && j != y) {
            // do your test in here
        }
    }
}