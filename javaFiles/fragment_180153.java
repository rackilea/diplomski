void randomShip () {

    ship = new boolean[NUM_COLS][NUM_ROWS];
    click = new boolean[NUM_COLS][NUM_ROWS];

    shipLength = (int)random (3, 8);

    int store = (int)random(vert, horz);  
    if (store >= 0) {

        int randomX = (int)random(NUM_COLS - shipLength);
        int randomY = (int)random(NUM_ROWS);

        for (int i = 0; i < shipLength; i++ ) {
            ship[randomX + i][randomY] = true;
        }
    } else  {

        int randomX = (int)random(NUM_COLS);
        int randomY = (int)random(NUM_ROWS - shipLength); 

        for (int i = 0; i < shipLength; i++ ) {
            ship[randomX][randomY+1] = true;
        }
    }
    println(shipLength);
}