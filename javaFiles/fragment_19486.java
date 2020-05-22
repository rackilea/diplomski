public static void addGenre(Integer a, String b){
    ...
    rowsAdded = stmt.executeUpdate(query);
    if (rowsAdded > 0) {
        DefaultTableModel model = (DefaultTableModel)tab1.getModel();
        model.addRow( new Object[] { a, b });
    }
}