private JTable table = new JTable(1, 2);
...
table.getModel().addTableModelListener(new TableModelListener() {

    @Override
    public void tableChanged(TableModelEvent e) {
        System.out.println(""
            + e.getType() + " "
            + e.getFirstRow() + " "
            + e.getLastRow() + " " 
            + e.getColumn());
    }
});