private int getColumnByName(JTable table, String name) {
    for (int i = 0; i < table.getColumnCount(); ++i)
        if (table.getColumnName(i).equals(name))
            return i;
    return -1;
}