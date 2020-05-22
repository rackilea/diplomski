JTable table = new JTable(data, columnNames) {
    public void changeSelection(int row, int column, boolean toggle, boolean extend) {
        super.changeSelection(row, column, toggle, extend);
        if (editCellAt(row, column))
        {
            Component editor = getEditorComponent();
            editor.requestFocusInWindow();
        }
    }
};