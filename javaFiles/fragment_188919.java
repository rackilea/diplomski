private static boolean hovering = false;

public static void main(String[] args)
{
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    final Label label = new Label(shell, SWT.NONE);
    final Image image = display.getSystemImage(SWT.ICON_ERROR);

    Listener mouseHover = new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            hovering = e.type == SWT.MouseEnter;
            label.redraw();
        }
    };

    label.addListener(SWT.MouseEnter, mouseHover);
    label.addListener(SWT.MouseExit, mouseHover);
    label.addListener(SWT.Paint, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            int x = label.getBounds().width / 2 - image.getBounds().width / 2;
            int y = label.getBounds().height / 2 - image.getBounds().height / 2;
            e.gc.drawImage(image, x, y);

            if(hovering)
            {
                e.gc.setAlpha(50);
                e.gc.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));
                e.gc.fillRectangle(label.getBounds());
            }
        }
    });

    shell.pack();
    shell.setSize(100, 100);
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}