import java.util.*;

public class MessageReceiver {

    public static void main( String[] args ) {

        Scanner scan = new Scanner( System.in );

        while ( true ) {

            String message = scan.nextLine();
            System.out.printf( "string \"%s\" received...\n", message );

            System.out.flush();
            System.err.flush();

            if ( message.equals( "end" ) ) {
                break;
            }

        }

    }

}