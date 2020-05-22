import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CaesarCypher {

    public static final int MOVE_DOWN = 4;
    public static void main(String [] args)
    {

       String plainText = "";
       char character;

       System.out.println("Enter sentence or word to Encrypt: ");
       InputStreamReader converter = new InputStreamReader(System.in);
       BufferedReader in = new BufferedReader(converter);
       try{
           plainText = in.readLine();

           for ( int iteration = 0 ; iteration < plainText.length() ; iteration++ ) 
           {
               character = plainText.charAt( iteration );
               if ( character >='A' && character <= 'Z' ) 
               {
                   character = (char) ( 'A' + ( character - 'A' + MOVE_DOWN ) %26 );
               }

               System.out.print(character);
           }
       }
       catch (Exception e){
           System.err.println(e.getMessage());
       }

    }
}