public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final Combo combo = new Combo(shell, SWT.NONE);

    combo.add("First");
    combo.add("Second");

    combo.addListener(SWT.Selection, new Listener() {

        @Override
        public void handleEvent(Event arg0) {
            System.out.println("Selected: " + combo.getItem(combo.getSelectionIndex()));
        }
    });

    combo.addListener(SWT.KeyUp, new Listener() {

        @Override
        public void handleEvent(Event arg0) {
            System.out.println("Typed");
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}