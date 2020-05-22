TableViewer viewer = ....

TableLayout layout = new TableLayout();

TableViewerColumn col1 = new TableViewerColumn(viewer, SWT.LEAD);
layout.setColumnData(col1.getColumn(), new ColumnWeightData(60));

TableViewerColumn col2 = new TableViewerColumn(viewer, SWT.LEAD);
layout.setColumnData(col2.getColumn(), new ColumnWeightData(40));

viewer.getTable().setLayout(layout);