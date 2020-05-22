import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public final class ExampleDriver
{
  public static void main ( String args[] ) throws Exception
  {
    SpecialResource specialResource = new SpecialResource ();

    Server server = new Server ( 19080 );

    WebAppContext waCtx = new WebAppContext ();
    waCtx.setAttribute ( "com.example.SpecialResource", SpecialResource );
    waCtx.setWar ( "path/to/war/file.war" );

    server.setHandler ( waCtx );
    server.start ();
    server.join ();
  }
}