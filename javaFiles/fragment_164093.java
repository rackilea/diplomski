public static int firstRowContainsObject(JTable table, Object obj) {
    for (int i = 0; i < table.getRowCount(); i++) {
        for (int j = 0; j < table.getColumnCount(); j++) {
            if (Objects.equals(obj, table.getValueAt(i, j))) {
                return i;
            }
        }
    }
    return -1;
}