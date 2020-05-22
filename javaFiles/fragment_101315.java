import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.regex.Pattern;
///------------------------------------------------------------------------------
public class ZZ
{
    final static String  LineSeparator     = System.getProperty( "line.separator" ); //  ODOA (<CR><LF>) on Win7
    final static String  MessageSeparator  = Pattern.quote( LineSeparator );         //  5C510D0A5C45 = RegEx string "\Q<CR><LF>\E" on Win7
    final static Pattern EndOfMessageRegEx = Pattern.compile( MessageSeparator );
    final static String  CharacterEncoding = "US-ASCII";    // or UTF-8, UTF-16, ISO-8859-1, etc,

    //----------------------------------------------------------------------------------

    public static void main( String[] args ) 
            throws IOException 
    {
        String hostName   = "localhost";  // = 127.0.0.1
        int    portNumber = 14576;                    

        try  (
            Socket         TcpipLink    = new Socket( hostName, portNumber );
            BufferedReader FromServer   = new BufferedReader( new InputStreamReader( TcpipLink.getInputStream(), CharacterEncoding ) );
            Scanner        ReceivedData = new Scanner( FromServer ).useDelimiter( EndOfMessageRegEx );                              
        ) {                      
            String ReceivedMessage;
            while ( (ReceivedMessage = ReceivedData.next()) !=  null ) {
                 //Process the Inbound message 
            }           
            System.out.println( "Client fell out off message handler loop" ); // should never get here
        } 
        catch ( UnknownHostException e )  {
            System.err.println( "Don't know about host " + hostName );
            System.exit( 1 );
        } 
        catch ( IOException e ) {
            System.err.println( "Could not connect to " +  hostName + "on port" + portNumber );
            System.exit( 1 );
        }

        System.out.println( "Client exited" );

    }   // end function main()

}   // end class "ZZ"