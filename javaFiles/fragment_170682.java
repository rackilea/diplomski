private static class NameLabelProvider extends OwnerDrawLabelProvider
  {
    private static final int TEXT_MARGIN = 3;

    @Override
    protected void erase(final Event event, final Object element)
    {
      event.detail &= ~SWT.FOREGROUND;
    }

    @Override
    protected void measure(final Event event, final Object element)
    {
      final TableData data = (TableData)element;
      final String text = data.getName();
      final Point size = event.gc.textExtent(text);
      event.width = size.x + 2 * TEXT_MARGIN;
      event.height = Math.max(event.height, size.y + TEXT_MARGIN);
    }

    @Override
    protected void paint(final Event event, final Object element)
    {
      final TableData data = (TableData)element;
      final String text = data.getName();
      event.gc.drawText(text, event.x + TEXT_MARGIN, event.y, true);
    }
  }