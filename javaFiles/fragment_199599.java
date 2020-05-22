class MatrixOfObjects { // class declaration should not have a "()"
    private Optional<MyObjectClass>[][] map_use;

    public MatrixOfObjects(Integer nRows, Integer nCols) {
        map_use = (Optional<MyObjectClass>[][]) new Optional[nRows][nCols];
    }

    public MyObjectClass getCellContents(Integer row, Integer col) {
         return map_use[row][col].get();
    }

    public void setCellContents(MyObjectClass e, Integer row, Integer col) {
         // removed "return" keyword, since you don't return anything from this method
         // used correct array assignement + Optional.of() to create the Optional
         map_use[row][col] = Optional.of(e); 
    }

    public void emptyCellContents(Integer row, Integer col) {
         // unlike lists, arrays do not have a "set()" method. You have to use standard array assignment
         map_use[row][col] = Optional.absent();
    }

    public Boolean isCellUsed(Integer row, Integer col) {
         return map_use[row][col].isPresent();
    }
}