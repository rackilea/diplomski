for(int col = 0; col < tm.getColumnCount(); col++){
        Object val = tm.getValueAt(row, col);
        pst.setObject(col+1, val);

}
pst.addBatch();