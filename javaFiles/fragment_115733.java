public static void main(String[] args)
{
    Display d = new Display();
    final Shell shell = new Shell(d);
    shell.setLayout(new GridLayout(1, false));

    new Label(shell, SWT.NONE).setText("Bet type:");

    final Combo betType = new Combo(shell, SWT.SINGLE | SWT.BORDER);
    betType.setItems(new String[] {"   ", "NFL", "NBA", "CFB"});

    betType.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            System.out.println(betType.getText());
        }
    });


    shell.pack();
    shell.open();
    while (!shell.isDisposed())
        while (!d.readAndDispatch())
            d.sleep();
}