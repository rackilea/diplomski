public static Cursor getCursor(final Display display)
{
  OverlayImageDescriptor overlay = new OverlayImageDescriptor();

  Cursor result = new Cursor(display, overlay.getImageData(), 0, 0);

  return result;
}

private static class OverlayImageDescriptor extends CompositeImageDescriptor
{
  private final ImageData base;

  OverlayImageDescriptor()
  {
    base = ImageDescriptor.createFromFile(ImageProvider.class, "arrow.pnh").getImageData();
  }

  @Override
  protected void drawCompositeImage(int width, int height)
  {
    Display display = Display.getCurrent();

    // Overlay image

    Image image = new Image(display, 13, 13);

    GC gc = new GC(image);

    Color color = new Color(display, new RGB(0, 255 ,0));

    gc.setBackground(color);
    gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
    gc.fillRectangle(0, 0, 12, 12);
    gc.drawRectangle(0, 0, 12, 12);

    gc.dispose();
    color.dispose();

    drawImage(image.getImageData(), 3, 3);

    image.dispose();

    // Draw base image over the top of the overlay

    drawImage(base, 0, 0);
  }

  @Override
  protected Point getSize()
  {
    return new Point(base.width, base.height);
  }