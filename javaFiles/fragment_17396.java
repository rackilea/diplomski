signalTable.setModel(new DefaultTableModel(
    new Object[][] {
        {"AAA", "A_SIGNAL", null, null, null, null, null, null, null, null, "Example", Boolean.TRUE},
    },
    new String[] {
        "ID", "Message Identifier", "0", "1", "2", "3", "4", "5", "6", "7", "Description", ""
    }
) {
    Class[] columnTypes = new Class[] {
        String.class, String.class, JButton.class, JButton.class, JButton.class, JButton.class, JButton.class, JButton.class, JButton.class, JButton.class, String.class, Boolean.class
    };
    public Class getColumnClass(int columnIndex) {
        return columnTypes[columnIndex];
    }
});