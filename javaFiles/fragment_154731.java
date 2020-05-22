int totalWidth = 200;

// draw big grid
drawGrid(g, 0, 0, totalWidth);

// draw small grids
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        drawGrid(g, totalWidth / 3 * i, totalWidth / 3 * j, totalWidth / 3);
    }
}