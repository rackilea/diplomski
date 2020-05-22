int ROWS_NUM = (int) canvas.getHeight() / rectangleSize;
int COLS_NUM = (int) canvas.getWidth() / rectangleSize;

List<List<Cell>> array = new ArrayList<List<Cell>>();

for (int x = 0; x < COLS_NUM; x++) {
    List inner = new ArrayList<Cell>();
    for (int y = 0; y < ROWS_NUM; y++) {
        inner.add(new Cell());
    }
    array.add(inner);
}