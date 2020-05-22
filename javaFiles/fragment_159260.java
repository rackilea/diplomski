public class TreeEditorTest {

    private final Display display;
    private final Shell shell;

    public TreeEditorTest() {
        display = new Display();
        shell = new Shell(display);
        shell.setLayout(new FillLayout());

        final Composite baseComposite = new Composite(shell, SWT.NONE);
        baseComposite.setLayout(new GridLayout());
        baseComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        final Tree table = new Tree(baseComposite, SWT.BORDER | SWT.FULL_SELECTION);
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        final int columnWidth = 100;
        new TreeColumn(table, SWT.NONE, 0).setWidth(columnWidth);
        new TreeColumn(table, SWT.NONE, 1).setWidth(columnWidth);
        new TreeColumn(table, SWT.NONE, 2).setWidth(columnWidth);
        new TreeColumn(table, SWT.NONE, 3).setWidth(columnWidth);
        new TreeColumn(table, SWT.NONE, 4).setWidth(columnWidth);

        final String[] strings = new String[] { "Column 1", "Column 2", "Column 3", "Column 4", "Column 5" };

        final TreeItem parent = new TreeItem(table, SWT.NONE);
        parent.setText(strings);

        final TreeItem child1 = new TreeItem(parent, SWT.NONE);
        child1.setText(strings);
        final TreeItem child2 = new TreeItem(parent, SWT.NONE);
        child2.setText(strings);

        parent.setExpanded(true);

        final TreeEditor editor = new TreeEditor(table);
        editor.horizontalAlignment = SWT.LEFT;
        editor.grabHorizontal = true;

        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseUp(final MouseEvent e) {
                final Control oldEditor = editor.getEditor();
                if (oldEditor != null) {
                    oldEditor.dispose();
                }

                final Point p = new Point(e.x, e.y);
                final TreeItem item = table.getItem(p);
                if (item == null) {
                    return;
                }
                for (int i = 0; i < table.getColumnCount(); ++i) {
                    if (item.getBounds(i).contains(p)) {
                        final int columnIndex = i;
                        // The control that will be the editor must be a
                        final Text newEditor = new Text(table, SWT.NONE);

                        newEditor.setText(item.getText(columnIndex ));

                        newEditor.addModifyListener(new ModifyListener() {
                            public void modifyText(final ModifyEvent e) {
                                final Text text = (Text) editor.getEditor();
                                editor.getItem().setText(columnIndex , text.getText());
                            }
                        });
                        newEditor.selectAll();
                        newEditor.setFocus();
                        editor.setEditor(newEditor, item, columnIndex );
                    }
                }
            }

        });

    }

    public void run() {
        shell.setSize(600, 200);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    public static void main(final String... args) {
        new TreeEditorTest().run();
    }

}