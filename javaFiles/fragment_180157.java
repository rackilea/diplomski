final int CELLSIZE = 50;
final int NUM_ROWS = 10;
final int NUM_COLS = 12;

int horz = (int)random(50);
int vert = (int)random(-50);

int store;
int shipLength;

boolean [][] ship;
boolean [][] click;

int hitCount = 0;
int missCount = 0;

void setup() {
    size(600, 500);
    randomShip();
    println(store);
}

void draw() {

    drawCells(255);

    if (hitCount == shipLength ) {

        // [...]

    }
}

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

void randomShip () {

    ship = new boolean[NUM_COLS][NUM_ROWS];
    click = new boolean[NUM_COLS][NUM_ROWS];
    hitCount = 0;
    missCount = 0;

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

void mouseClicked () {

    int cell_x = mouseX / CELLSIZE; 
    int cell_y = mouseY / CELLSIZE;

    if (!click[cell_x][cell_y]) {
        click[cell_x][cell_y] = true;

        if ( ship[cell_x][cell_y] ) {
            hitCount ++;
        } else {
            missCount ++;
        }
    }
}