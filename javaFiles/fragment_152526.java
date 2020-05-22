public static void main(String args[])
{
    Display display = new Display();
    final Shell shell = new Shell(display, SWT.BORDER | SWT.PRIMARY_MODAL | SWT.RESIZE);
    shell.setText(" Test table ");
    shell.setLayout(new GridLayout(1, true));

    final Table table = new Table(shell, SWT.BORDER | SWT.CHECK | SWT.V_SCROLL | SWT.FULL_SELECTION);
    table.setHeaderVisible(true);
    table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    for(int col = 0; col < 5; col++)
    {
        new TableColumn(table, SWT.NONE).setText("column " + col);
    }
    for (int row = 0; row < 10; row++)
    {
        TableItem item = new TableItem(table, SWT.NONE);

        for(int col = 1; col < table.getColumnCount(); col++)
        {
            item.setText(col, "cell " + row + " " + col);
        }
    }
    for(int col = 0; col < table.getColumnCount(); col++)
    {
        table.getColumn(col).pack();
    }

    Button close = new Button(shell, SWT.PUSH);
    close.setText("Done");
    shell.setDefaultButton(close);
    close.setLayoutData(new GridData(SWT.FILL, SWT.END, true, false));

    close.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            shell.dispose();
        }
    });
    table.addListener(SWT.MouseUp, new Listener()
    {
        public void handleEvent(Event e)
        {
            if (table.getItemCount() > 0)
            {
                Rectangle rect = table.getItem(new Point(e.x, e.y)).getBounds(0);
                if (rect.contains(new Point(e.x, e.y)) || e.x <= rect.x)
                    System.out.println("first column or checkbox clicked");
                else
                    System.out.println("other column clicked");
            }
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!shell.getDisplay().readAndDispatch())
            shell.getDisplay().sleep();
    }
}