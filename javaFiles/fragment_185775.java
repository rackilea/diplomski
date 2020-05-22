MyCheckBoxTreeViewer treeViewer = new MyCheckBoxTreeViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
GridDataFactory.fillDefaults().grab(true, true).applyTo(treeViewer.getTree());
treeViewer.setContentProvider(contentProvider);
treeViewer.setLabelProvider(labelProvider);
treeViewer.setSorter(sorter);
treeViewer.setAutoExpandLevel(2); 
treeViewer.setInput("root");