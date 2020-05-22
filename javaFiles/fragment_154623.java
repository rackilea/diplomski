import java.util.Arrays; 
public class BattleshipGrid {
    private char[][] arr1 = new char[10][10];
    private char[][] arr2 = new char[10][10];
    private char[][] arr3 = new char[10][10]; 
    private char[][] arr4 = new char[10][10];

    public void initializeTheGrid() {
        for (char[] i: arr2) {
            for(char j: i) {
                i[j]='X';
            }
        }
    }


    public static void main (String[] args) {
        BattleshipGrid grid = new BattleshipGrid();
        grid.initializeTheGrid();
    }
}