public LA2_MazeSolver() {
    }

public void setNumRows(int numRows) {
    this.rows = numRows;
}

public void setNumCols(int numCols) {
    this.cols = numCols;
}

public void init(){
    this.maze = new String[rows][cols];
}