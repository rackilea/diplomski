@Override
public void createPartControl(Composite parent) {

  Canvas canvas = new Canvas(parent, SWT.NONE);

  canvas.addPaintListener(new PaintListener()
    {
      @Override
      public void paintControl(final PaintEvent event)
      {
        GC gc = event.gc;

        gc.drawLine(0, 0, 100, 100);
        gc.drawLine(100, 0, 0, 100);
      }
    });