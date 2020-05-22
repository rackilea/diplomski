import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.ListIterator;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Ravi P
 */
public class Test {

    public static void main( String[] args ) {

        try {

            List<List<Integer>> jsonParentArr = new ObjectMapper().readValue( new File( "C:\\tmp\\Details.json" ), new TypeReference<List<List<Integer>>>() {
            } ); // read the data from file and form a list

            System.out.println( jsonParentArr.get( 2 ) ); // array values before replacing 30

            ListIterator<Integer> childJsonArr = jsonParentArr.get( 2 ).listIterator(); // get the 3rd array

            while ( childJsonArr.hasNext() ) {

                if ( childJsonArr.next() == 30 ) { // replace if the value to 10.0 if the exsting value is 30

                    childJsonArr.set( 10 );
                }
            }

            System.out.println( jsonParentArr.get( 2 ) ); // array values after replacing 30

            try (BufferedWriter bWriter = new BufferedWriter( new FileWriter( "C:\\tmp\\Details.json" ) )) {

                bWriter.write( jsonParentArr.toString() ); // write back the result to same file

            } catch ( Exception e ) {

                e.printStackTrace();
            }

        } catch ( Exception e ) {

            e.printStackTrace();

        }
    }
}