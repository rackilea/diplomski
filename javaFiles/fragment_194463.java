public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout(SWT.VERTICAL));

    final ScrolledComposite composite = new ScrolledComposite(shell, SWT.V_SCROLL);
    composite.setLayout(new FillLayout());

    final Text text = new Text(composite, SWT.MULTI | SWT.BORDER | SWT.WRAP);

    composite.setContent(text);
    composite.setExpandHorizontal(true);
    composite.setExpandVertical(true);
    composite.setMinSize(text.computeSize(SWT.DEFAULT, SWT.DEFAULT));

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Add text and disable");
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            text.setText("lalala\nlalala\nlalala\nlalala\nlalala\nlalala\n");
            text.setEnabled(false);
            composite.setMinSize(text.computeSize(SWT.DEFAULT, SWT.DEFAULT));
        }
    });

    shell.pack();
    shell.setSize(300, 150);
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}