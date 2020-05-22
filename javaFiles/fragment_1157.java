class Cell {
    Cell( int x, int y ){...}
    Cell( int x, int y, int value ){...}
    int getX(){...}
    int getY(){...}
    int getValue(){...}
}

class Table {
    Table( int rows, int cols ){...}
    void put( Cell c ){...}
    Cell get( int x, int y ){...}
}