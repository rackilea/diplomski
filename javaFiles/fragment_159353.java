public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell();
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    final Text text = new Text(shell, SWT.BORDER);

    text.addListener(SWT.Verify, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            final String oldS = text.getText();
            final String newS = oldS.substring(0, e.start) + e.text + oldS.substring(e.end);

            int difference = oldS.length() - newS.length();

            if(difference > 0)
                System.out.println("User deleted " + difference + " characters");
            else if(difference < 0)
                System.out.println("User added " + Math.abs(difference) + " characters");
        }
    });

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();
}