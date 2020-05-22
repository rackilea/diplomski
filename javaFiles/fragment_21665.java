private static class JTextAreaWithExtendedRowHeight extends JTextArea{
    private JTextAreaWithExtendedRowHeight( int rows, int columns ) {
      super( rows, columns );
    }

    @Override
    public FontMetrics getFontMetrics( Font font ) {
      FontMetrics fontMetrics = super.getFontMetrics( font );
      return new FontMetricsWrapper( font, fontMetrics );
    }
  }