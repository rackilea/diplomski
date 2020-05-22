class Maze{
    private int startRow, startCol, finishRow, finishCol;

    public Maze(String[] textmaze, int startRow, int startCol, int finishRow, int finishCol){
        this.startRow = startRow;
        this.startCol = startCol;
        this.finishRow = finishRow;
        this.finishCol = finishCol;
    }

    private void someMethod(){
        System.out.println(startRow);
    }

}