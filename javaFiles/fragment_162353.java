public static void main(String[] args)
{
    final Display d = new Display();
    Shell s = new Shell(d);
    s.setLayout(new FillLayout());

    Table table = new Table(s, SWT.NONE);
    Font font = new Font(null, "", 12, SWT.BOLD);
    for (int i = 0; i < 3; i++)
    {
        TableItem item = new TableItem(table, SWT.NONE);
        item.setFont(font);
        item.setText("" + i);
    }

    table.addListener(SWT.Dispose, e -> font.dispose());

    s.pack();
    s.open();

    while (!s.isDisposed())
    {
        if (!d.readAndDispatch())
            d.sleep();
    }
    d.dispose();
}