public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(2, false));

    Composite myComposite = new Composite(shell, SWT.NONE);
    myComposite.setLayout(new GridLayout(1, false));
    myComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Composite deComposite = new Composite(myComposite, SWT.NONE);
    deComposite.setLayout(new RowLayout(SWT.HORIZONTAL));

    Label createDetailsde = createDetailsde(deComposite);

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}

private static Label createDetailsde(Composite detailsComposite)
{
    Label linkLabel = new Label(detailsComposite, SWT.NONE);
    linkLabel.setText("test");
    return linkLabel;
}