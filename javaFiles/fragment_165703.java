tableViewer = new TableViewer(tabFolder_1, SWT.BORDER | SWT.FULL_SELECTION);
    table = tableViewer.getTable();
    table.setLinesVisible(true);
    table.setHeaderVisible(true);
    tbtmRmv.setControl(table);

    tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
    tblclmnMyCol = tableViewerColumn.getColumn();
    tblclmnMyCol.setWidth(100);
    tblclmnMyCol.setText("My col");