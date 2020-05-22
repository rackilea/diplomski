public class L4JOS extends OutputStream {
  logger = Logger.getLogger( "std.out" );
  private int lineEnd = (int)'\n';
  private ByteArrayOutputStream baos = new ByteArrayOutputStream();

  public void write( int b ) throws IOException {
    baos.write( b );
    if ( b == lineEnd ) {
      logger.info( baos.toString() );
      baos.reset();
    }
  }

}