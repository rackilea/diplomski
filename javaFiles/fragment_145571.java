public class CellGrid extends JPanel implements Runnable{
    private static final int ROWS = 60;
    private static final int COLS = 60;
    private static final int CELL_WIDTH = 10;
    private Cell[][] cellGrid = new Cell[ROWS][COLS]; // make this non-static

    public CellGrid() {
        reset();
    }

    public void reset() {   
        cellGrid = new Cell[ROWS][COLS];
        for (int row = 0; row < cellGrid.length; row++) {
            for (int col = 0; col < cellGrid[row].length; col++) {
                int x = col * CELL_WIDTH;
                int y = row * CELL_WIDTH;
                cellGrid[row][col] = new Cell(x, y, CELL_WIDTH);

                if (new Random().nextBoolean()) {
                    cellGrid[row][col].setAlive(true);
                } else {
                    cellGrid[row][col].setAlive(false);
                }
            }
        }
    }

// ..... more code below