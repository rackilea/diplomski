public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell();
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    Group group = new Group(shell, SWT.NONE);
    group.setText("Group");
    group.setLayout(new GridLayout(1, false));
    group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    ScrolledComposite scroll = new ScrolledComposite(group, SWT.V_SCROLL | SWT.H_SCROLL);
    scroll.setLayout(new GridLayout(1, false));
    scroll.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Image image = new Image(display, "stackoverflow.png");

    Label label = new Label(scroll, SWT.NONE);
    label.setImage(image);

    scroll.setContent(label);
    scroll.setExpandHorizontal(true);
    scroll.setExpandVertical(true);
    scroll.setMinSize(label.computeSize(SWT.DEFAULT, SWT.DEFAULT));

    shell.pack();
    shell.setSize(200, 200);
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();

    image.dispose();
}