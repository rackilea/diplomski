public static void main(final String[] args) throws Exception
{
    final FontRenderContext frc = new FontRenderContext(null, true, true);
    final Font font = new Font("serif", Font.PLAIN, 18);
    final TextLayout layout = new TextLayout("This is a test", font, frc);
    final Rectangle2D bounds = layout.getBounds();
    System.err.println((int) (bounds.getWidth() + .5));
}