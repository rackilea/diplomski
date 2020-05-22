import java.io.*;
import java.util.*;

public class Sender {

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {
        new Sender().execute();
    }

    public void execute() {

        try {

            // executes the command (the C executable)
            Process process = Runtime.getRuntime().exec( "MessageReceiver.exe" );

            // or, executes the MessageReceiver class
            //Process process = Runtime.getRuntime().exec( "java MessageReceiver" );

            // create the stream gobblers, one for the input stream and one for the
            // error stream. these gobblers will consume these streams.
            StreamGobbler sgInput = new StreamGobbler(
                    process.getInputStream(), "input" );
            StreamGobbler sgError = new StreamGobbler(
                    process.getErrorStream(), "error" );

            // creates a thread for each stream gobbler and start them
            new Thread( sgInput ).start();
            new Thread( sgError ).start();

            // creates a PrintWriter using the process output stream
            PrintWriter writer = new PrintWriter( process.getOutputStream() );

            // preparing to read user input
            Scanner scan = new Scanner( System.in );

            while ( true ) {

                System.out.println( "Send a command: " );
                String command = scan.nextLine();

                // sends the command to the process
                // simulating an user input (note the \n)
                writer.write( command );
                writer.write( "\n" );
                writer.flush();

                // if the command is end, finalizes this app too
                if ( command.equals( "end" ) ) {
                    break;
                }

            }

        } catch ( IOException ioe ) {
            ioe.printStackTrace();
        }

    }

    /**
     * Threads to consume the process streams.
     * Based in the implementation presented here:
     * http://www.javaworld.com/javaworld/jw-12-2000/jw-1229-traps.html?page=1
     *
     * @author David Buzatto
     */
    private class StreamGobbler implements Runnable {

        private InputStream is;
        private String type;
        private FileWriter fw;

        public StreamGobbler( InputStream is, String type ) {
            this.is = is;
            this.type = type;
        }

        public StreamGobbler( InputStream is, String type, File file )
                throws IOException {
            this.is = is;
            this.type = type;
            this.fw = new FileWriter( file );
        }

        @Override
        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader( is );
                BufferedReader br = new BufferedReader( isr );
                String line = null;
                while ( ( line = br.readLine() ) != null ) {
                    if ( fw != null ) {
                        fw.write( line + "\n" );
                    } else {
                        System.out.println( type + ">" + line );
                    }
                }
                if ( fw != null ) {
                    fw.close();
                }
            } catch ( IOException ioe ) {
                ioe.printStackTrace();
            }
        }
    }

}