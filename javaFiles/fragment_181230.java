public void listAllCurtains() throws SQLException {
    DefaultTableModel deftm = (DefaultTableModel) allTable.getModel();

    if (deftm.getRowCount() != 0) {
        deftm.setRowCount(0);
    }
    allCurtains.clear(); // ***** add this *****

    // ..... more code