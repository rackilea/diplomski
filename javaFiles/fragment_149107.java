public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Button");

    button.addListener(SWT.Selection, new Listener() {

        @Override
        public void handleEvent(Event arg0) {
            shell.setEnabled(!shell.getEnabled());
            shell.setCursor(new Cursor(display, SWT.CURSOR_WAIT));      
            recursiveSetEnabled(shell, shell.getEnabled());
        }
    });

    new Text(shell, SWT.NONE).setText("TEXT");

    shell.setSize(400, 400);
    shell.open();

    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}

private static void recursiveSetEnabled(Control control, boolean enabled) {
    if (control instanceof Composite)
    {
        Composite comp = (Composite) control;

        for (Control c : comp.getChildren())
            recursiveSetEnabled(c, enabled);
    }
    else
    {
        control.setEnabled(enabled);
    }
}