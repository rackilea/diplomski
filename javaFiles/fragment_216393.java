public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell();
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    Group first = new Group(shell, SWT.NONE);
    first.setText("Group 1");
    first.setLayout(new GridLayout(1, false));
    GridData firstData = new GridData(SWT.FILL, SWT.FILL, true, false);
    firstData.heightHint = 400;
    first.setLayoutData(firstData);

    ScrolledComposite firstScroll = new ScrolledComposite(first, SWT.V_SCROLL);
    firstScroll.setLayout(new GridLayout(1, false));
    firstScroll.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Composite firstContent = new Composite(firstScroll, SWT.NONE);
    firstContent.setLayout(new GridLayout(1, false));
    firstContent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    for (int i = 0; i < 20; i++)
    {
        Text text = new Text(firstContent, SWT.BORDER);
        text.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
    }

    firstScroll.setContent(firstContent);
    firstScroll.setExpandHorizontal(true);
    firstScroll.setExpandVertical(true);
    firstScroll.setMinSize(firstContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));

    Group second = new Group(shell, SWT.NONE);
    second.setText("Group 2");
    second.setLayout(new GridLayout(1, false));
    GridData secondData = new GridData(SWT.FILL, SWT.FILL, true, true);
    secondData.minimumHeight = 100;
    second.setLayoutData(secondData);

    Text text = new Text(second, SWT.BORDER | SWT.MULTI);
    text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    shell.pack();
    shell.setSize(400, shell.getSize().y);
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