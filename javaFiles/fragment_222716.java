public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());
    shell.setText("Stackoverflow");

    final Table table = new Table(shell, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
    table.setHeaderVisible(true);
    table.setLinesVisible(true);

    int columnCount = 3;
    for (int i = 0; i < columnCount; i++)
    {
        TableColumn column = new TableColumn(table, SWT.BORDER);
        column.setText("Column " + i);
    }
    for (int i = 0; i < 10; i++)
    {
        TableItem item = new TableItem(table, SWT.BORDER);
        item.setText(new String[]{"cell " + i + " 0", "cell " + i + " 1", "cell " + i + " 2"});
    }

    final Listener paintListener = event ->
    {
        switch (event.type)
        {
            case SWT.MeasureItem:
            {
                TableItem item = (TableItem) event.item;
                String text = item.getText(event.index);
                Point size = event.gc.textExtent(text);
                event.width = size.x;
                event.height = Math.max(event.height, size.y);
                break;
            }
            case SWT.PaintItem:
            {
                TableItem item = (TableItem) event.item;
                String text = item.getText(event.index);
                Point size = event.gc.textExtent(text);
                int offset2 = event.index == 0 ? Math.max(0, (event.height - size.y) / 2) : 0;
                event.gc.drawText(text, event.x, event.y + offset2, true);
                break;
            }
            case SWT.EraseItem:
            {
                event.detail &= ~SWT.FOREGROUND;
                break;
            }
        }
    };

    table.addListener(SWT.MeasureItem, paintListener);
    table.addListener(SWT.PaintItem, paintListener);
    table.addListener(SWT.EraseItem, paintListener);

    final TableEditor editor = new TableEditor(table);
    editor.horizontalAlignment = SWT.LEFT;
    editor.grabHorizontal = true;
    editor.grabVertical = true;

    table.addSelectionListener(new SelectionAdapter()
    {
        @Override
        public void widgetSelected(SelectionEvent e)
        {
            Control oldEditor = editor.getEditor();
            if (oldEditor != null)
                oldEditor.dispose();

            TableItem item = (TableItem) e.item;
            if (item == null)
                return;

            Text newEditor = new Text(table, SWT.WRAP | SWT.BORDER);
            newEditor.setText(item.getText(1));
            newEditor.addModifyListener(me ->
            {
                Text text = (Text) editor.getEditor();
                editor.getItem().setText(1, text.getText());

                // Redraw the table so that it'll adjust the row height
                table.redraw();
                // Wait a bit and then relayout the editor, so it'll move to the correct position
                display.timerExec(100, editor::layout);
            });
            newEditor.selectAll();
            newEditor.setFocus();
            editor.setEditor(newEditor, item, 1);
        }
    });

    for (int i = 0; i < 3; i++)
    {
        table.getColumn(i).pack();
    }

    shell.pack();
    shell.open();

    while (!shell.isDisposed())

    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}