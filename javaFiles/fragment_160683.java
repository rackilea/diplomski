public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final Composite treeComposite = new Composite(shell, SWT.NONE);
    treeComposite.setLayout(new GridLayout());

    final ToolBar treeToolBar = new ToolBar(treeComposite, SWT.NONE);
    treeToolBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

    final Text filterText = new Text(treeToolBar, SWT.BORDER);

    final ToolItem textItem = new ToolItem(treeToolBar, SWT.SEPARATOR);
    textItem.setControl(filterText);
    textItem.setWidth(filterText.computeSize(SWT.DEFAULT, SWT.DEFAULT, true).x);

    final ToolItem separator = new ToolItem(treeToolBar, SWT.SEPARATOR);
    separator.setWidth(0);

    final ToolItem item1 = new ToolItem(treeToolBar, SWT.PUSH | SWT.RIGHT);
    item1.setImage(display.getSystemImage(SWT.ICON_WORKING));

    final ToolItem item2 = new ToolItem(treeToolBar, SWT.PUSH | SWT.RIGHT);
    item2.setImage(display.getSystemImage(SWT.ICON_QUESTION));

    treeToolBar.pack();
    final int trimSize = treeToolBar.getSize().x - textItem.getWidth() - item1.getWidth() - item2.getWidth();

    treeToolBar.addListener(SWT.Resize, new Listener() {
        @Override
        public void handleEvent(Event event) {
            final int toolbarWidth = treeToolBar.getSize().x;
            final int itemsWidth = textItem.getWidth() + item1.getWidth() + item2.getWidth();
            final int separatorWidth = toolbarWidth - itemsWidth - trimSize;
            separator.setWidth(separatorWidth);
        }
    });

    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}