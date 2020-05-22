@Override
public Class getColumnClass(int col) {
    if (col == 3) {
        return java.util.Date.class;
    }
    // return the appropriate class for every column
}