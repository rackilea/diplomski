Action copyCell = new AbstractAction()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JTable table = (JTable)e.getSource();
        int row = table.getSelectedRow();
        int column = table.getSelectedColumn();
        Object value = table.getValueAt(row, column);

        // copy the data to the clipboard

        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection testData = new StringSelection( value.toString() );
        c.setContents(testData, testData);
    }
};

table.getActionMap().put("copy", copyCell);