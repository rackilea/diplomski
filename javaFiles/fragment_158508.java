import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class Test {

    public static void main( String[] args ) {
        TreeMap<String, Object> myMap = new TreeMap<String, Object>();
        myMap.put( "111-hello", null );
        myMap.put( "111-world", null );
        myMap.put( "111-test", null );
        myMap.put( "111-java", null );

        myMap.put( "123-one", null );
        myMap.put( "123-two", null );
        myMap.put( "123--three", null );
        myMap.put( "123--four", null );

        myMap.put( "125-hello", null );
        myMap.put( "125--world", null );

        System.out.println( "111 \t" + getByPrefix( myMap, "111" ) );
        System.out.println( "123 \t" + getByPrefix( myMap, "123" ) );
        System.out.println( "123-- \t" + getByPrefix( myMap, "123--" ) );
        System.out.println( "12 \t" + getByPrefix( myMap, "12" ) );
    }

    private static SortedMap<String, Object> getByPrefix(
            NavigableMap<String, Object> myMap,
            String prefix ) {
        return myMap.subMap( prefix, prefix + Character.MAX_VALUE );
    }
}