private Composite   container;
private Canvas      canvas;
private Image       img;

public ImgCanvas(Composite parent)
{
    container = new Composite(parent, SWT.NONE);
    container.setLayout(new GridLayout(1, false));
    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    canvas = new Canvas(container, SWT.BORDER);
    canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    initCanvas();
}

public ImgCanvas(Composite parent, Image img)
{
    this(parent);
    setImage(img);
}

public void setImage(Image img)
{
    this.img = img; // keep this below setCanvas() to avoid being disposed.
    System.out.println("Set image: " + img.getBounds() + ", " + img.toString());
    redraw();
}

public void redraw()
{
    System.out.println("redrawing");
    canvas.redraw();
}

protected void initCanvas()
{
    System.out.println("Canvas started");
    canvas.addPaintListener(new PaintListener()
    {
        public void paintControl(PaintEvent e)
        {
            System.out.println("Painting");
            if (img != null)
            {
                System.out.println("Img:" + img.getBounds());
                e.gc.drawImage(img, 0, 0);
                System.out.println("Canvas: " + canvas.getBounds());
            }
            else
                System.out.println("Img is null: " + img);
        }
    });
    canvas.addDisposeListener(new DisposeListener()
    {
        @Override
        public void widgetDisposed(DisposeEvent e)
        {
            System.out.println("Disposing");
            if (img != null)
            {
                img.dispose();
            }
        }
    });
}