public class SudokuSolver 
{
    public Coordinates hint(int[][] puzzle, int[][] solved)
    {
        List<Coordinates> availableCells=getAvailableCells(puzzle);
        int chosenIndex=(int)Math.random()*availableCells.size();
        Coordinates chosenCell=availableCells.get(chosenIndex);
        int chosenRow=chosenCell.getRow();
        int choseColumn=chosenCell.getColumn();
        puzzle[chosenRow][chosenColumn]=solved[chosenRow][chosenColumn];
        return chosenCell;
    }

    private List<Coordinates> getAvailableCells(int[][] puzzle)
    {
        List<Coordinates> list=new ArrayList<Coordinates>(MAX_ROWS*MAX_COLUMNS);
        // iterate the puzzle and collect every cell ==0
        return list;
    }
}