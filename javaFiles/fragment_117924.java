public static void main(String[] args) {

    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setBounds(10,10,300,300);
    Button b =new Button(shell, SWT.NONE);
    b.setText("Button");
    b.setBounds(60,60,80,80);
    Button button = new Button(shell, SWT.PUSH);
    button.setText("NewButton");

    button.setBounds(120,120,90,90);
    button.moveAbove(b); shell.open();

    while (!shell.isDisposed()) {
    if (!display.readAndDispatch()) display.sleep();
    }
    display.dispose();
    }