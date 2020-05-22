private static boolean wait = false;

private static Cursor cursor = null;

public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Change cursor");

    button.addListener(SWT.Selection, new Listener() {

        @Override
        public void handleEvent(Event arg0) {
            wait = !wait;

            if(cursor != null)
                cursor.dispose();

            cursor = wait ? new Cursor(display, SWT.CURSOR_WAIT) : new Cursor(display, SWT.CURSOR_ARROW);

            shell.setCursor(cursor);
        }
    });


    shell.setSize(200,200);
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();

    if(cursor != null)
        cursor.dispose();
}