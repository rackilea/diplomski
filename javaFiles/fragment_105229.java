private int minRow;
private int maxRow;
private int minCol;
private int maxCol;
private T element;

public Board(int minRow, int maxRow, int minCol, int maxCol, T fillElem){
    this.minRow = minRow;
    this.maxRow = maxRow;
    this.minCol = minCol;
    this.maxCol = maxCol;

    if(fillElem == null){
        throw new RuntimeException("Cannot set elements to null");
    }
    else {
        this.element = fillElem;
    }

    myBoard = new ArrayList<ArrayList<T>>();
    populateBoard();
}

public void setFillElem(T f){
    this.element = f;
    populateBoard();
    //this = new DenseBoard(minRow, maxRow, minCol, maxCol, f);
}

private void populateBoard() {
    // empty existing elements
    myBoard.clear();

    if((minRow >= 0 && maxRow >=0) && (minCol >= 0 && maxCol >= 0)){
        int row = maxRow - minRow;
        int col = maxCol - minCol;
        ArrayList<T> rowLine;
        for(int i = 0; i <= row; i++){
            rowLine = new ArrayList<T>();
            myBoard.add(rowLine);
            for(int j = 0; j <= col; j++){
                rowLine.add(j, this.element);
            }
        }
    }