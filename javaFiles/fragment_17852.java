public boolean notValid(int x, int y) {
    return x >= cr.NUM_ROWS || y >= cr.NUM_COLUMNS || x < 0 || y < 0;
}

public gridState(int xpos, int ypos) {
    if (! notvalid(xpos, ypos)) {
        x = xpos;
        y = ypos;
    } else {
        // new position not valid -> just stay where you are
    }
}