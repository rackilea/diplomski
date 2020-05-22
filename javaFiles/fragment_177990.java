public class OffsetCalc {
private int rows;
private int cols;
private int rowsOther;
private int colsOther;

public OffsetCalc(int rows, int cols, int rowsOther, int colsOther) {
    this.rows = rows;
    this.cols = cols;
    this.rowsOther = rowsOther;
    this.colsOther = colsOther;
}

public void getOffset(int i) {
    int col = i % cols;
    int row = i / cols;
    System.out.println("i=" + i + " @row,col: " + row + "," + col);

    int other = (col) + (row * rowsOther);
    System.out.println("i=" + i + " @Other image: " + other);
}

public static void main(String[] args) {
    OffsetCalc calc = new OffsetCalc(4, 4, 20, 6);
    for (int i = 0; i <= 14; i++) {
        calc.getOffset(i);
    }
}
}