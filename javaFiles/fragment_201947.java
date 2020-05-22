import  java.util.Hashtable;
import  javax.naming.*;
import  javax.naming.directory.*;

public class MXLookup {
  public static void main( String args[] ) {
    if( args.length == 0 ) {
      System.err.println( "Usage: MXLookup host [...]" );
      System.exit( 99 );
    }
    for( int i = 0; i < args.length; i++ ) {
      try {
        System.out.println( args[i] + " has " +
          doLookup( args[i] ) + " mail servers" );
      }
      catch( Exception e ) {
        System.out.println(args[i] + " : " + e.getMessage());
      }
    }
  }

  static int doLookup( String hostName ) throws NamingException {
    Hashtable env = new Hashtable();
    env.put("java.naming.factory.initial",
            "com.sun.jndi.dns.DnsContextFactory");
    DirContext ictx = new InitialDirContext( env );
    Attributes attrs = 
       ictx.getAttributes( hostName, new String[] { "MX" });
    Attribute attr = attrs.get( "MX" );
    if( attr == null ) return( 0 );
    return( attr.size() );
  }
}