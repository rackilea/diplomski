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