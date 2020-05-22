public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell();
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(2, true));

    final Composite left = new Composite(shell, SWT.NONE);
    Composite right = new Composite(shell, SWT.NONE);
    left.setLayout(new GridLayout(3, true));
    right.setLayout(new GridLayout(3, true));

    for (int i = 0; i < 6; i++)
    {
        new Label(left, SWT.NONE).setText("label-" + i);
        new Label(right, SWT.NONE).setText("label-" + i);
    }

    display.addFilter(SWT.MouseMove, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            if (isChildOrSelf(e.widget, left))
                System.out.println(e);
        }
    });

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

private static boolean isChildOrSelf(Widget child, Composite parent)
{
    if(child == parent)
        return true;

    for (Control c : parent.getChildren())
    {
        if (c instanceof Composite)
        {
            boolean result = isChildOrSelf(child, (Composite)c);
            if (result)
                return true;
        }
        else if (c == child)
            return true;
    }

    return false;
}