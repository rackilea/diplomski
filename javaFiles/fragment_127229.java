public static void main(String[] args)
{
    final Display display = Display.getDefault();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    Menu bar = new Menu(shell, SWT.BAR);
    shell.setMenuBar(bar);

    MenuItem fileItem = new MenuItem(bar, SWT.CASCADE);
    fileItem.setText("&File");
    Menu submenu = new Menu(shell, SWT.DROP_DOWN);
    fileItem.setMenu(submenu);

    File dir = new File("C:\\");

    for (File file : dir.listFiles())
    {
        if (file.isFile())
        {
            MenuItem item = new MenuItem(submenu, SWT.NONE);
            item.setText(file.getName());
        }
    }

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
}