public static void tweakColumns(JTable table){
    Enumeration<TableColumn> columns = table.getColumnModel().getColumns();

    int required = 0;
    while(columns.hasMoreElements()){
        TableColumn column = columns.nextElement();
        int width = (int)table.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(table, column.getIdentifier()
                            , false, false, -1, column.getModelIndex()).getPreferredSize().getWidth();
        required += width;
    }

    JViewport viewport = (JViewport)SwingUtilities.getAncestorOfClass(JViewport.class, table);
    int viewportWidth = viewport.getWidth();
    table.setAutoResizeMode(required<viewportWidth ? JTable.AUTO_RESIZE_ALL_COLUMNS : JTable.AUTO_RESIZE_OFF);
}