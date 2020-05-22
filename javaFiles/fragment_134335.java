public boolean isCellEditable(int row, int col) {
    if(getValueAt(row,0) instanceof SerieTv) { // getValueAt(row, 0) == null        
        return cETv[col];
    }
    else {        
        return cEFilm[col]; // col == 9 == 10th element in cEFilm array == false
    }
}