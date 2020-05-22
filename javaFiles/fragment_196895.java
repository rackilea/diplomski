public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    Label label = new Label(shell, SWT.NONE);
    label.setText("Right-click here");

    Menu menu = new Menu(label);
    MenuItem item = new MenuItem(menu, SWT.PUSH);
    item.setText("Context-menu item");
    item.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            System.out.println("clicked");
        }
    });

    label.setMenu(menu);

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