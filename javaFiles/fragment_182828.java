public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    // Create the ScrolledComposite to scroll horizontally and vertically
    ScrolledComposite scrolledComp = new ScrolledComposite(shell, SWT.H_SCROLL | SWT.V_SCROLL);

    // Create a child composite for your content
    Composite content = new Composite(scrolledComp, SWT.NONE);
    content.setLayout(new FillLayout());

    // Create some content
    new Button(content, SWT.PUSH).setText("Button1");
    new Button(content, SWT.PUSH).setText("Button2");

    // add content to scrolled composite
    scrolledComp.setContent(content);

    // Set the minimum size (in this case way too large)
    scrolledComp.setMinSize(400, 400);

    // Expand both horizontally and vertically
    scrolledComp.setExpandHorizontal(true);
    scrolledComp.setExpandVertical(true);

    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}