public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("Stackoverflow");
    shell.setLayout(new FillLayout());

    ScrolledComposite sc = new ScrolledComposite(shell, SWT.V_SCROLL | SWT.H_SCROLL);

    Button button = new Button(sc, SWT.NONE);
    button.setText("Hello! This is a button with a lot of text...");

    sc.setContent(button);
    sc.setExpandHorizontal(true);
    sc.setExpandVertical(true);
    sc.setMinSize(button.computeSize(SWT.DEFAULT, SWT.DEFAULT));

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}