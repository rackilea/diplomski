public void addRowBottom(){
        int origRow = maxRow - minRow;
        int col = maxCol - minCol;

        ArrayList<T> rowLine = new ArrayList<T>();
        myBoard.add(origRow + 1, rowLine);

        for(int j = 0; j <= col; j++){
            rowLine.add(j, this.element);
        }
    }