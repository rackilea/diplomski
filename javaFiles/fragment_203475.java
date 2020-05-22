public static void main(String[] args) {

    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout());

    Composite c = new Composite(shell, SWT.NONE);
    c.setLayoutData(new GridData());  // default values so it doesn't grab excess space
    c.setLayout(new FillLayout());

    Button myCheckbox = new Button(c, SWT.CHECK);
    myCheckbox.setText("Checkbox text");
    myCheckbox.setToolTipText("Tooltip message");
    myCheckbox.setEnabled(false);

    // assign the same tooltip to the encapsulating composite
    myCheckbox.getParent().setToolTipText(myCheckbox.getToolTipText());  

    shell.setSize(200, 200);
    shell.open();

    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}