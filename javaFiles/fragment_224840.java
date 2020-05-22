public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("Stackoverflow");
    shell.setLayout(new FillLayout());

    Image image = new Image(display, "baz.png");

    Label label = new Label(shell, SWT.NONE);
    label.addListener(SWT.Paint, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            GC gc = event.gc;

            gc.drawImage(image, 0, 0);

            gc.setAlpha(30);

            int interval = image.getBounds().height;

            for (int i = 0; i < 10; i++)
            {
                int y = (int) Math.floor(i * (interval / 10.0));

                gc.drawLine(0, y, image.getBounds().width, y);
            }


            interval = image.getBounds().width;

            for (int i = 0; i < 10; i++)
            {
                int x = (int) Math.floor(i * (interval / 10.0));

                gc.drawLine(x, 0, x, image.getBounds().width);
            }

            gc.setAlpha(255);
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
    image.dispose();
}