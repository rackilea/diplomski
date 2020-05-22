public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setSize(600, 400);
    shell.setText("Decorations Example");
    shell.setLayout(new GridLayout(1,true));

    Decorations d1 = new Decorations(shell, SWT.NO_TRIM);
    d1.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_CYAN));

    Decorations d2 = new Decorations(shell, SWT.DIALOG_TRIM);
    d2.setText("dialog");

    Decorations d3 = new Decorations(shell, SWT.SHELL_TRIM);
    d3.setText("shell trim");

    Decorations d4 = new Decorations(shell, SWT.TOOL);
    d4.setText("tool");
    d4.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_DARK_YELLOW));
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
  }