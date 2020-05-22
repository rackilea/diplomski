public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell();
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    final Text text = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
    text.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

    text.addListener(SWT.Modify, new Listener()
    {
        private int height  = 0;

        @Override
        public void handleEvent(Event arg0)
        {
            int newHeight = computeHeight(text, 3);

            if (newHeight != height)
            {
                height = newHeight;
                GridData gridData = (GridData) text.getLayoutData();
                gridData.heightHint = height;
                text.setLayoutData(gridData);
                text.getParent().layout(true, true);
            }
        }
    });

    shell.pack();
    shell.setSize(400, 300);
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

private static int computeHeight(Text text, int maxHeight)
{
    int height = text.getText().split("\n", -1).length;
    return Math.min(height, maxHeight) * text.getLineHeight();
}