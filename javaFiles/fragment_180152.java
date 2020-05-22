void setup() {
    size(600, 500);
    randomShip();
    println(store);
}

void draw() {
    // randomShip(); <---- delete
    drawCells (row, column, shipLength, (255) );
}