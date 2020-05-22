private static Tree createTree(final Composite parent, final String text, final String... columns) {
    final Composite group = GUIToolkit.newGroup(parent, SWT.NONE, text, new GridData(SWT.FILL, SWT.FILL, true, true)); // <-- THIS
    group.setFont(FontManager.NORMAL_BOLD);
    group.setLayout(new FillLayout());
    final Tree tree = new Tree(group, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
    tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true)); // <-- THIS
    tree.setHeaderVisible(true);
    GUIToolkit.createColumns(tree, columns);
    GUIToolkit.addColumnSort(tree, DATA);
    GUIToolkit.removeDoubleClickExpand(tree);
}