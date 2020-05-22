public static void main(final String [] args)
{
  // Create the display
  Display display = new Display();
  try
   {
     // Create main shell
     Shell shell = new Shell(display, SWT.SHELL_TRIM);

     shell.setText("Shell Title");

     shell.setLayout(new FillLayout());

     // Put framework in the shell
     new Framework(shell, SWT.NONE);

     // Open the shell
     shell.open();

     // Main event dispatch loop
     while (!shell.isDisposed())
      {
        if (!display.readAndDispatch())
          display.sleep();
      }
    }
  finally
   {
     // Clean up
     display.dispose();
   }
}