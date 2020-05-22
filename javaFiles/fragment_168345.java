public static void main(String[] args)
{
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());
    shell.setText("ExpandBar Example");

    final ScrolledComposite scrolledComp = new ScrolledComposite(shell, SWT.V_SCROLL);

    final ExpandBar bar = new ExpandBar(scrolledComp, SWT.NONE);

    for (int i = 0; i < 3; i++)
    {
        Composite composite = new Composite(bar, SWT.NONE);
        composite.setLayout(new GridLayout());

        for (int j = 0; j < 10; j++)
            new Label(composite, SWT.NONE).setText("Label " + i + " " + j);

        ExpandItem item = new ExpandItem(bar, SWT.NONE, 0);
        item.setText("Item " + i);
        item.setHeight(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
        item.setControl(composite);
    }

    bar.getItem(1).setExpanded(true);
    bar.setSpacing(8);

    /* Make sure to update the scrolled composite when we collapse/expand
     * items */
    Listener updateScrolledSize = new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            display.asyncExec(new Runnable()
            {
                @Override
                public void run()
                {
                    scrolledComp.setMinSize(bar.computeSize(SWT.DEFAULT, SWT.DEFAULT));
                }
            });
        }
    };

    bar.addListener(SWT.Expand, updateScrolledSize);
    bar.addListener(SWT.Collapse, updateScrolledSize);

    scrolledComp.setContent(bar);
    scrolledComp.setExpandHorizontal(true);
    scrolledComp.setExpandVertical(true);
    scrolledComp.setMinSize(bar.computeSize(SWT.DEFAULT, SWT.DEFAULT));

    shell.setSize(400, 200);
    shell.open();

    /* Jump to the end */
    scrolledComp.setOrigin(0, scrolledComp.getSize().y);

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();
}