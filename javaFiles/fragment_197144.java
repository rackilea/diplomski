final Object[] object = { null }
display.syncExec( new Runnable() {
  public void run() {
    Clipboard clipBoard = new Clipboard( display );
    object[ 0 ] = clipBoard.getContents( TextTransfer.getInstance() );
    clipboard.dispose();
  }
} );