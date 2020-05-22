public class Board<T> {
private T element;
private int minCol;
private int maxCol;
private int minRow;
private int maxRow;
private int rowCount;
private int colCount;
private List<List<T>> myBoard;

public Board(int minRow, int maxRow, int minCol, int maxCol, T fillElem) {
    this.minRow = minRow;
    this.maxRow = maxRow;
    this.minCol = minCol;
    this.maxCol = maxCol;
    this.rowCount = maxRow - minRow + 1;
    this.colCount = maxCol - minCol + 1;

    if (fillElem == null) {
        throw new RuntimeException("Cannot set elements to null");
    } else {
        this.element = fillElem;
    }

    myBoard = new ArrayList<List<T>>(rowCount);
    for (int i = 0; i < rowCount; i++) {
        List<T> rowLine = new ArrayList<T>(colCount);
        myBoard.add(rowLine);
        for (int j = 0; j < colCount; j++)
            rowLine.add(element);
    }
}

private T getCellValueAt(int row, int column) {
    return myBoard.get(row - minRow).get(column - minCol);
}

@Override
public String toString() {
    StringBuilder builder = new StringBuilder();
    String result = "";
    if (this.element instanceof String) {
        String elem = (String) this.element;
        String firstLine1 = "   ";
        String firstLine2 = "   ";
        String first1 = "";
        String first2 = "";
        String secondLine1 = "";
        String secondLine2 = "   ";

        switch (elem.length()) {
        case 1:
            result = "";
            // Contructs the first two lines!
            firstLine1 = "   ";
            firstLine2 = "   ";
            first1 = "";
            first2 = "";
            for (int i = 0; i < colCount; i++) {
                if (i >= 0) {
                    first1 += "|  " + i;
                } else {
                    first1 += "| " + i;
                }
                first2 += "+---";
            }
            firstLine1 += first1 + "|\n";
            firstLine2 += first2 + "+\n";

            // Constrcuts the rest!
            secondLine1 = "";
            secondLine2 = "   ";

            for (int row = minRow; row <= maxRow; row++) {
                if (row >= 0) {
                    secondLine1 += " " + row + " ";
                } else {
                    secondLine1 += row + " ";
                }

                for (int column = minCol; column <= maxCol; column++) {
                    secondLine1 += "|  " + getCellValueAt(row, column);
                    secondLine2 += "+---";
                }
                secondLine1 += "|\n";
                secondLine1 += secondLine2 + "+\n";
                secondLine2 = "   ";

                // secondLine2 += "+\n   ";
            }

            result += firstLine1 + firstLine2 + secondLine1; // + secondLine2;
            break;
        }
        return builder.append(result).toString();
    }
    return "";
}

public static void main(String[] args) {
    Board<String> board = new Board<String>(-4, 1, -2, 4, "A");
    System.out.println(board);
}