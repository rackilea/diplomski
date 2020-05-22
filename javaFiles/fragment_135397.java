public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    Group top = new Group(shell, SWT.NONE);
    top.setLayout(new GridLayout(1, false));
    top.setText("Top");
    top.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Group bottom = new Group(shell, SWT.NONE);
    bottom.setLayout(new GridLayout(1, false));
    bottom.setText("Bottom");
    bottom.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Tree topTree = new Tree(top, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
    createColumns(topTree);
    Tree bottomTree = new Tree(bottom, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
    createColumns(bottomTree);

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();
}

private static void createColumns(Tree tree)
{
    tree.setHeaderVisible(true);

    for(int i = 0; i < 3; i++)
        new TreeColumn(tree, SWT.NONE).setText("Col " + i);

    for(int i = 0; i < 10; i++)
    {
        TreeItem item = new TreeItem(tree, SWT.NONE);

        for(int j = 0; j < tree.getColumnCount(); j++)
        {
            item.setText(j, "Item " + i + " " + j);
        }
    }

    for(int i = 0; i < tree.getColumnCount(); i++)
        tree.getColumn(i).pack();
}