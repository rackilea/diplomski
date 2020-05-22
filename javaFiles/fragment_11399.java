public class DisposeDemo {
  private static void addControls(final Shell shell) {
    shell.setLayout(new GridLayout());
    Button button = new Button(shell, SWT.PUSH);
    button.setText("Click to remove all controls from shell");
    button.addSelectionListener(new SelectionListener() {
      @Override public void widgetDefaultSelected(SelectionEvent event) {}
      @Override public void widgetSelected(SelectionEvent event) {
        for (Control kid : shell.getChildren()) {
          kid.dispose();
        }
      }
    });
    for (int i = 0; i < 5; i++) {
      Label label = new Label(shell, SWT.NONE);
      label.setText("Hello, World!");
    }
    shell.pack();
  }

  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    addControls(shell);
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}