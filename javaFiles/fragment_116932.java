private static boolean buttonOnTop = true;

public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");

    shell.setLayout(new FillLayout());

    Button switchButton = new Button(shell, SWT.NONE);
    switchButton.setText("Switch");

    final StackLayout layout = new StackLayout();

    final Composite content = new Composite(shell, SWT.NONE);
    content.setLayout(layout);

    final Button button = new Button(content, SWT.PUSH);
    button.setText("Button");

    final Label label = new Label(content, SWT.NONE);
    label.setText("Label");

    layout.topControl = button;

    switchButton.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            layout.topControl = (buttonOnTop) ? label : button;
            content.layout();

            buttonOnTop = !buttonOnTop;
        }
    });

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}