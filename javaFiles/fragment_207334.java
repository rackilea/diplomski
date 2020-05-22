public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));
    shell.setText("StackOverflow");

    Composite contentHolder = new Composite(shell, SWT.NONE);
    contentHolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    contentHolder.setLayout(new GridLayout(1, false));

    createMenuBar(shell);
    createContent(contentHolder);

    shell.pack();
    shell.setSize(600, 400);
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

private static void createContent(Composite parent)
{
    Button button = new Button(parent, SWT.NONE);
    button.setText("connect");
    button.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

    Canvas canvas = new Canvas(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
    canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
}

private static void createMenuBar(final Shell shell)
{
    Menu menuBar = new Menu(shell, SWT.BAR);
    MenuItem fileItem = new MenuItem(menuBar, SWT.CASCADE);
    fileItem.setText("File");
    MenuItem helpItem = new MenuItem(menuBar, SWT.CASCADE);
    helpItem.setText("Action");

    Menu fileMenu = new Menu(menuBar);
    fileItem.setMenu(fileMenu);
    MenuItem exitItem = new MenuItem(fileMenu, SWT.NONE);
    exitItem.setText("Exit");

    Menu aboutMenu = new Menu(menuBar);
    helpItem.setMenu(aboutMenu);
    MenuItem aboutItem = new MenuItem(aboutMenu, SWT.NONE);
    aboutItem.setText("Some action");

    shell.setMenuBar(menuBar);
}