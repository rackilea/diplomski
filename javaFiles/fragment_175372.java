public class TestClass {

public static final String[][] removeRow( String[][] source, String rowName ) {
    boolean rowFound = false;
    for ( int i = 0; i < source.length; i++ ) {
        if ( source[ i ][ 0 ].equals( rowName ) ) {
            rowFound = true;
        }
    }
    if ( !rowFound ) {
        return source;
    }

    String[][] result = new String[ source.length - 1][ source[ 0 ].length ];
    int resultIndex = 0;
    for ( int i = 0; i < source.length; i++ ) {
        if ( !source[ i ][ 0 ].equals( rowName ) ) {
            System.arraycopy( source[ i ], 0, result[ resultIndex ], 0, source[ i ].length );
            resultIndex++;
        } 

    }

    return result;
}

@Test
public void test() {
    String[][] source = { 
            { "1", "one", "I", "eins" }, 
            { "2", "two", "II", "zwei" }, 
            { "3", "three", "III", "drei" }, 
            { "4", "four", "IV", "vier" } 
    };

    String[][] result = removeRow( source, "2" );
    assertEquals( "{[1, one, I, eins][3, three, III, drei][4, four, IV, vier]}", toString( result ) );

    result = removeRow( source, "rowNotIn" );
    assertEquals( "{[1, one, I, eins][2, two, II, zwei][3, three, III, drei][4, four, IV, vier]}", toString( result ) );
}

private String toString( String[][] source ) {
    StringBuffer sb = new StringBuffer();
    sb.append( "{" );
    for ( int i = 0; i < source.length; i++ ) {
        sb.append( Arrays.toString( source[ i ] ) );
    }
    sb.append( "}" );
    return sb.toString();
}