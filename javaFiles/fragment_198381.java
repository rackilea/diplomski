static void updateChildren( Composite parent ) {
  for( Control child : parent.getChildren() ) {
    if( child instanceof ProcessingControl ) {
      ( ( ProcessingControl )child ).doProcessing();
    }
    if( child instanceof Composite ) {
      updateChildren( ( Composite )child );
    }
  }
}