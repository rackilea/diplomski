public void setValueAt(Object value, int row, int col) {
    super.setValueAt(value, row, col);
    if (col == 4) {
        if ((Boolean) this.getValueAt(row, col) == true) {
            //code goes here
        }
        else if ((Boolean) this.getValueAt(row, col) == false) {
            //code goes here
        }
    }   
}