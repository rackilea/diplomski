import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class InputTest{

    private int INPUT_LIMIT = 10000;

    public static void main( String [] args ) {
        InputTest test = new InputTest();
        System.out.println("Start typing numbers...");
        List list = test.readRange( 2.0 );
        System.out.println("The input was " +  list );
    }

    /**
     * Read from the standar input until endSignal number is typed.
     * Also limits the amount of entered numbers to 10000;
     * @return a list with the numbers.
     */
    public List readRange( double endSignal ) {
        List<Double> input = new ArrayList<Double>();
        Scanner kdb = new Scanner( System.in );
        int count = 0;
        double number = 0;
        while( ( number = kdb.nextDouble() ) != endSignal && count < INPUT_LIMIT ){
            System.out.println( number );
            input.add( number );
        }
        return input;
    }
}