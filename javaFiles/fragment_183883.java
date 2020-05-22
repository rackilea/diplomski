public void addRowBottom(){
        int origRow = maxRow - minRow;
        int col = maxCol - minCol;

        ArrayList<T> rowLine = new ArrayList<T>();

        maxRow = maxRow + 1; //here you are updating the maxNumber of rows
        myBoard.add(origRow + 1, rowLine);

        for(int j = 0; j <= col; j++){
            rowLine.add(j, this.element);
        }
    }