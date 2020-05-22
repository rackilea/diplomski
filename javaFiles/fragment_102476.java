public class ControlSwitcher {
    public static void main(String[] args) {
        Display display = new Display();
        final Shell shell = new Shell(display);
        GridLayout gl = new GridLayout();
        gl.marginWidth = gl.marginHeight = 20;
        shell.setLayout(gl);

        final Composite c1 = new Composite(shell, SWT.NONE);
        c1.setBackground(new Color(display, 255, 160, 160));
        RowLayout layout = new RowLayout(SWT.VERTICAL);
        c1.setLayout(layout);

        final Composite c2 = new Composite(c1, SWT.NONE);
        c2.setBackground(new Color(display, 160, 255, 160));
        c2.setLayout(new RowLayout());

        final Label lbl = new Label(c2, SWT.NORMAL);
        lbl.setText("Hello world");

        final Button btn = new Button(c2, SWT.PUSH);
        btn.setText("Switch");
        btn.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent arg0) {
                Composite target;
                if (btn.getParent().equals(c2)) {
                    target = c1;
                } else {
                    target = c2;
                }
                boolean success = btn.setParent(target);
                if (success) {
                    target.pack();
                    shell.pack();
                } else {
                    throw new RuntimeException("Not supported by this platform");
                }
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent arg0) {
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
}