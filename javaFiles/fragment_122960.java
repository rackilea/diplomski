for (int column = 0; column < columnModel.getColumnCount(); column++) {
    TableColumn tableColumn = columnModel.getColumn(column);
    TableCellRenderer renderer = tableColumn.getHeaderRenderer();
    if (renderer == null) {
        renderer = getTableHeader().getDefaultRenderer();
    }
    Component component = renderer.getTableCellRendererComponent(this, 
             tableColumn.getHeaderValue(), false, false, -1, column);
    minSizeMap.put(tableColumn.getModelIndex(), component.getPreferredSize().width);
}