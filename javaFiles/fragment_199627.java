activeViewer = new TableViewer(parent,
            SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE | SWT.FULL_SELECTION);
    final Table activeTable = activeViewer.getTable();

    AutoResizeTableLayout layout = new AutoResizeTableLayout(activeTable);
    activeTable.setLayout(layout);

    layout.addColumnData(new ColumnWeightData(400));
    layout.addColumnData(new ColumnPixelData(70));