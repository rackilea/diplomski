public static void main(String[] args) 
{       
    Display display=new Display();
    Shell shell=new Shell();

    // Set a layout
    shell.setLayout(new FillLayout());
    shell.setText("Hi there!");

    Button pushButton = new Button(shell, SWT.PUSH);
    pushButton.setText("Im a Push Button");

    // Move the shell stuff to the end
    shell.pack();
    shell.open();
    shell.setSize(500,500);

    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
}