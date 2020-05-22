class tableClass
{
    public Vector columnNames = null; 
    private JTable jTable; 
    DefaultTableModel model;

    public tableClass(JPanel jPanel, Vector rowDataInput, Vector columnNamesInput)
    {       
        Vector rowData = rowDataInput; 
        columnNames = columnNamesInput;

        jTable = new JTable(rowData, columnNames);
        jTable.setFillsViewportHeight(true);

        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setPreferredSize(new Dimension(300, 100));
        jPanel.add(jScrollPane,BorderLayout.CENTER);
    }

    public void updateTable(Vector rowDataInput)
    {
        Vector rowData = rowDataInput;  
        model =(DefaultTableModel)jTable.getModel();  
        model.fireTableDataChanged();
    }
}