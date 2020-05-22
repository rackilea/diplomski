public static void main(final String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout());

    // Your code below
    final ScrolledComposite scrollContainer = new ScrolledComposite(shell, SWT.V_SCROLL | SWT.BORDER);
    scrollContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    scrollContainer.setExpandVertical(true);
    scrollContainer.setExpandHorizontal(true); // Added
    scrollContainer.setAlwaysShowScrollBars(true);
    final Color white = Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
    scrollContainer.setBackground(white);

    final Composite scrollInner = new Composite(scrollContainer, SWT.NONE);
    scrollInner.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    scrollInner.setBackground(white);
    scrollInner.setLayout(new GridLayout(1, false));

    final Label text = new Label(scrollInner, SWT.NONE);
    text.setText("test1test2test3");
    text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    scrollContainer.setContent(scrollInner);
    // End your code

    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}