public void replace( FilterBypass fb, int offset, int length,
    String text, AttributeSet attrs ) throws BadLocationException
{
  if ( text.startsWith( "a" ) )
  {
    SimpleAttributeSet newAttrs = new SimpleAttributeSet();
    StyleConstants.setForeground( newAttrs, Color.RED );
    attrs = newAttrs;
  }

  super.replace( fb, offset, length, text, attrs );
}