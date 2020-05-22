JTable table = new JTable(...)
{
    //  Place cell in edit mode when it 'gains focus'

    public void changeSelection(
        int row, int column, boolean toggle, boolean extend)
    {
        super.changeSelection(row, column, toggle, extend);

        if (editCellAt(row, column))
        {
            Component editor = getEditorComponent();
            editor.requestFocusInWindow();
//          ((JTextComponent)editor).selectAll();
        }
    }

};