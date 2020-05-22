TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
TabItem item = new TabItem(tabFolder, SWT.NONE);
item.setText("Table");

GitToDoTree viewer = new GitToDoTree(tabFolder);
item.setControl(viewer.getTable()); // Possible setControl call?

TabItem item2= new TabItem(tabFolder, SWT.NONE);
item2.setText("Empty");