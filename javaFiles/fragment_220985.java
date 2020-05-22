int getRowByValue(TableModel model, Object value) {
    for (int i = model.getRowCount() - 1; i >= 0; --i) {
        for (int j = model.getColumnCount() - 1; j >= 0; --j) {
            if (model.getValueAt(i, j).equals(value)) {
                // what if value is not unique?
                return i;
            }
        }
    }
 }