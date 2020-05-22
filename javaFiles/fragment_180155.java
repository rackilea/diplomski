void drawCells(int colour) {

    for (int i = 0; i < NUM_COLS; i++) {
        for (int j = 0; j < NUM_ROWS; j++) {

            float x = i * CELLSIZE;
            float y = j * CELLSIZE;

            if (ship[i][j]) {
                fill (colour);
                rect(x, y, CELLSIZE, CELLSIZE);
            }

            if (click[i][j]) {
                fill(255, 0, 0);
                textSize(15);
                text(ship[i][j] ? "hit" : "miss", x+10, y+30); 
            }
        }
    }
}