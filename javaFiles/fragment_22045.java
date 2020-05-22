private static int          x               = 0;
private static int          y               = 0;
private static int          r               = 5;

// The timer interval in milliseconds
private static final int    TIMER_INTERVAL  = 10;

public static void main(String[] args)
{
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final Canvas canvas = new Canvas(shell, SWT.NONE);

    canvas.addListener(SWT.Paint, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            e.gc.drawOval(x++, y++, r, r);
        }
    });

    final Runnable drawThread = new Runnable()
    {
        @Override
        public void run()
        {
            canvas.redraw();

            if(x < 400 && y < 400)
                display.timerExec(TIMER_INTERVAL, this);
        }
    };

    display.timerExec(TIMER_INTERVAL, drawThread);

    shell.pack();
    shell.setSize(400, 400);
    shell.open();
    while (!shell.isDisposed())
        if (!display.readAndDispatch())
            display.sleep();

    // Kill the timer
    display.timerExec(-1, drawThread);
    display.dispose();
}