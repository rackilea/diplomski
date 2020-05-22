public class ImageButton extends Composite
{
    private Color   textColor;
    private Image   image;
    private String  text;
    private int     width;
    private int     height;

    public ImageButton(Composite parent, int style)
    {
        super(parent, style);

        textColor = Display.getDefault().getSystemColor(SWT.COLOR_WHITE);

        /* Add dispose listener for the image */
        addListener(SWT.Dispose, new Listener()
        {
            @Override
            public void handleEvent(Event arg0)
            {
                if (image != null)
                    image.dispose();
            }
        });

        /* Add custom paint listener that paints the stars */
        addListener(SWT.Paint, new Listener()
        {
            @Override
            public void handleEvent(Event e)
            {
                paintControl(e);
            }
        });

        /* Listen for click events */
        addListener(SWT.MouseDown, new Listener()
        {
            @Override
            public void handleEvent(Event arg0)
            {
                System.out.println("Click");
            }
        });
    }

    private void paintControl(Event event)
    {
        GC gc = event.gc;

        if (image != null)
        {
            gc.drawImage(image, 1, 1);
            Point textSize = gc.textExtent(text);
            gc.setForeground(textColor);
            gc.drawText(text, (width - textSize.x) / 2 + 1, (height - textSize.y) / 2 + 1, true);
        }
    }

    public void setImage(Image image)
    {
        this.image = new Image(Display.getDefault(), image, SWT.IMAGE_COPY);
        width = image.getBounds().width;
        height = image.getBounds().height;
        redraw();
    }

    public void setText(String text)
    {
        this.text = text;
        redraw();
    }

    @Override
    public Point computeSize(int wHint, int hHint, boolean changed)
    {
        int overallWidth = width;
        int overallHeight = height;

        /* Consider hints */
        if (wHint != SWT.DEFAULT && wHint < overallWidth)
            overallWidth = wHint;

        if (hHint != SWT.DEFAULT && hHint < overallHeight)
            overallHeight = hHint;

        /* Return computed dimensions plus border */
        return new Point(overallWidth + 2, overallHeight + 2);
    }

    public static void main(String[] args)
    {
        Display display = Display.getDefault();
        Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, false));

        ImageButton button = new ImageButton(shell, SWT.NONE);
        button.setImage(new Image(display, "button.png"));
        button.setText("Button");

        shell.pack();
        shell.open();

        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}