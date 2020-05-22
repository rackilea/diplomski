import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CopyMatrix { 
    public static void main( String [] args ) { 

        Matrix m = new Matrix();
        m.add( Arrays.asList(0.0, 1.0, 2.0 ));
        m.add( Arrays.asList(3.0, 4.0, 5.0 ));
        m.add( Arrays.asList(6.0, 7.0, 8.0 ));

        System.out.println("m = \n" +  m );

        Matrix m1 = m.copy() ;

        m1.get( 0 ).set( 0 , 100.0 );
        m1.get( 2 ).set( 2 , -400.0 );


        System.out.printf( "After m = %n %s %n m1 = %n %s %n", m, m1);
    }
}
class Matrix extends ArrayList<List<Double>> {
    public Matrix copy() {
        Matrix copy = new Matrix();
        for( List<Double> each : this ) { 
            copy.add( new ArrayList<Double>( each ) );
        }
        return copy;
    }
}