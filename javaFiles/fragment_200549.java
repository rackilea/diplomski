viewer.setLabelProvider(new OwnerDrawLabelProvider()
  {
    @Override
    protected void paint(final Event event, final Object element)
    {
      String text = element.toString();

      GC gc = event.gc;

      int textHeight = gc.textExtent(text).y;

      int yPos = event.y + event.height - textHeight;

      gc.drawText(text, event.x, yPos);
    }


    @Override
    protected void measure(final Event event, final Object element)
    {
      event.height = 90;
    }


    @Override
    protected void erase(final Event event, final Object element)
    {
      // Stop the default draw of the foreground
      event.detail &= ~SWT.FOREGROUND;
    }
  });