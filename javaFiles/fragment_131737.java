import java.util.*;

public class BubbleSort {

    private static final int TOTAL_ELEMENTS = 5;

    private List < Integer > numbers;
    private boolean isSorted;
    private Random random;

    public BubbleSort () {
        random = new Random ();
        isSorted = true;
        numbers = new ArrayList < Integer > ( TOTAL_ELEMENTS );
        numbers.add ( new Integer ( 1 ) );
        numbers.add ( new Integer ( 2 ) );
        numbers.add ( new Integer ( 3 ) );
        numbers.add ( new Integer ( 4 ) );
        numbers.add ( new Integer ( 5 ) );
    }

    private void performTask () {
        int pass = 1;
        while ( pass <= numbers.size () ) {
            isSorted = true;
            for ( int i = 0; i <= ( numbers.size () - pass - 1 ); ++i ) {
                System.out.println ( "i: " + i + " pass: " + pass + "[ i ]: " + numbers.get ( i ) + " [ i + 1 ]: " + numbers.get ( i + 1 )  );
                if ( numbers.get ( i ).compareTo ( numbers.get ( i + 1 ) ) > 0 )  {
                    System.out.println ( "Entered if clause" );
                    Integer temp = numbers.get ( i );
                    numbers.set ( i, numbers.get ( i + 1 ) );
                    numbers.set ( i + 1,  temp );
                    isSorted = false;
                    display ();
                }
            }
            if ( isSorted ) {
                break;
            }
            ++pass;
        }
        System.out.println ( "Minimum passes: " + pass );
        display ();
    }

    private void display () {
        System.out.println ( "Array content: " );
        for ( Integer number : numbers ) {
            System.out.println ( number.intValue () );
        }
    }

    public static void main ( String [] args ) {
        new BubbleSort ().performTask ();
    }
}