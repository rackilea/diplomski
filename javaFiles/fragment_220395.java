Button button = new Button( shell, SWT.PUSH );
button.addPaintListener( new PaintListener() {
  @Override
  public void paintControl( PaintEvent event ) {
    event.gc.setBackground( event.display.getSystemColor( SWT.COLOR_GREEN ) );
    event.gc.fillRectangle( event.x, event.y, event.width, event.height );
    Image image = event.display.getSystemImage( SWT.ICON_QUESTION );
    event.gc.drawImage( image, 0, 0 );
  }
} );