final Display display = new Display();
final Shell shell = new Shell(display);
shell.setText("StackOverflow");
shell.setLayout(new GridLayout());

Button button = new Button(shell, SWT.PUSH);
button.setText("Open new Shell");
button.addListener(SWT.Selection, (event) -> {
    Shell child = new Shell(shell);
    child.setText("Child");
    child.setVisible(true);
    child.setSize(300,200);
});

shell.pack();
shell.open();

while (!shell.isDisposed())
{
    if (!display.readAndDispatch())
        display.sleep();
}
display.dispose();