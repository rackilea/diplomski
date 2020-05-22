public class MyModel extends AbstractTableModel {
    class CellValue {
        String value;
        int highlightStart;
        int highlightEnd;

        CellValue(String val) {
            this.value = val;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    CellValue[][] values = new CellValue[2][7];

    public MyModel() {
        for(int i = 0; i < 2; i++) {
            for(int j=0; j < 7; j++) {
                values[i][j] = new CellValue(i + ":" + j);
            }
        }
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public int getRowCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return values[rowIndex][columnIndex];
    }
}