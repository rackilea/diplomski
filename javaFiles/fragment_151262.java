public static void main(String[] args)
{
    Display display = Display.getDefault();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    ScrolledComposite scrollComp = new ScrolledComposite(shell, SWT.V_SCROLL | SWT.H_SCROLL);
    Composite innerComp = new Composite(scrollComp, SWT.NONE);
    innerComp.setLayout(new GridLayout(4, true));

    for(int i = 0; i < 32; i++)
        new Button(innerComp, SWT.PUSH).setText("Button");

    scrollComp.setMinHeight(innerComp.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
    scrollComp.setMinWidth(innerComp.computeSize(SWT.DEFAULT, SWT.DEFAULT).x);
    scrollComp.setContent(innerComp);
    scrollComp.setExpandHorizontal(true);
    scrollComp.setExpandVertical(true);
    scrollComp.setAlwaysShowScrollBars(true);

    shell.pack();
    shell.open();

    shell.setSize(200, 200);

    while(!shell.isDisposed())
    {
        if(!display.readAndDispatch())
            display.sleep();
    }
}