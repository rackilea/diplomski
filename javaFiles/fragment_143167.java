// IntStringSplit.java

import java.util.Scanner; import java.util.Arrays;


public class IntStringSplit {

    public static void main( String[] args ) {

        Scanner input = new Scanner( System.in );

        String[] empName = new String[4];
        int[] empNum = new int[4];

        System.out.println( "Enter the ID and name: ");

        for( int counter = 0; counter < 4; counter++ ) {
            int i = input.nextInt();
            String s = input.nextLine().trim();
            empNum[counter] = i;
            empName[counter] = s;
        }

        for( int i2 : empNum )
            System.out.printf( "The numbers are: %d%n", i2 );

        for( str s2 : empName )
            System.out.printf( "The names are: %s%n", s2 );

        System.out.println();
    }
}