public static void main(String[] args)
{
    Display display = Display.getDefault();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    /* Load the image and calculate size and ratio */
    final Image image = new Image(display, "settings.png");
    final Rectangle imageSize = image.getBounds();
    final double imageRatio = 1.0 * imageSize.width / imageSize.height;

    /* Define the canvas and set the background color */
    final Canvas canvas = new Canvas(shell, SWT.BORDER);
    canvas.setBackground(display.getSystemColor(SWT.COLOR_DARK_GRAY));
    canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    canvas.addListener(SWT.Paint, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            Rectangle canvasSize = canvas.getBounds();

            double canvasRatio = 1.0 * canvasSize.width / canvasSize.height;

            int newHeight;
            int newWidth;

            /* Determine scaled height and width of the image */
            if (canvasRatio > imageRatio)
            {
                newWidth = (int) (imageSize.width * (1.0 * canvasSize.height / imageSize.height));
                newHeight = (int) (canvasSize.height);
            }
            else
            {
                newWidth = (int) (canvasSize.width);
                newHeight = (int) (imageSize.height * (1.0 * canvasSize.width / imageSize.width));
            }

            /* Compute position such that the image is centered in the canvas */
            int top = (int) ((canvasSize.height - newHeight) / 2.0);
            int left = (int) ((canvasSize.width - newWidth) / 2.0);

            /* Draw the image */
            e.gc.drawImage(image, 0, 0, imageSize.width, imageSize.height, left, top, newWidth, newHeight);
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

    /* DISPOSE THE IMAGE !!! */
    image.dispose();
}