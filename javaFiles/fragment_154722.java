import java.text.SimpleDateFormat;
import java.text.ParseException;

class Test {
    public static void main( String [] args ) throws ParseException  {

        SimpleDateFormat in  = new SimpleDateFormat("MM/dd");
        SimpleDateFormat out = new SimpleDateFormat("MMMM, dd");

        System.out.println( out.format( in.parse("07/08") ) );

        // Verbose 
        //String input = "07/09";           
        //Date  date = in.parse( input );  
        //String output = out.format( date );
        //System.out.println( output );
    }
}