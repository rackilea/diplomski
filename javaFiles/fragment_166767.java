import java.util.*;
class Init { 
    public static void main( String ... args ) { 

        Random random = new Random();

        double[][] array = new double[10][10];

        for( int i = 0 ; i < array.length ; i++ ) { 
           for ( int j = 0 ; j < array[i].length ; j++ ) { 
              array[i][j] = random.nextInt(101);
           }
        }

        for( double[] a : array ) { 
            System.out.println( Arrays.toString( a ));
        }
    }
}