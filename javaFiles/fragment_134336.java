public Object getValueAt(int row, int column) {
    IFS ifs = listaMista.get(row);
    if(column == 0) {
        return ifs;
    }
    // all your code here
}