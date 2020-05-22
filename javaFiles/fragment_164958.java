public class BattleField{

    Cell[][] cellArray = new Cell[rowCount][colCount] ;

    ....

    public void draw(){
        for(Cell[]row : cellArray){
            for(Cell cell : row){
                cell.draw();
            }
        }
    }

    public boolean strike(int row, int col){
        Cell cell = cellArray[row][col];
        return cell.strike();
    }
}