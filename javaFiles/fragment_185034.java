for (int row = 0; row < peopleModel.getRowCount(); row++) {
    String r = "";
    for (int col = 0; col < peopleModel.getColumnCount(); col++) {
        r += peopleModel.getValueAt(row, col);
        if (col < peopleModel.getColumnCount() - 1) {
            r += "/";
        }
    }
    o.println(r);
}