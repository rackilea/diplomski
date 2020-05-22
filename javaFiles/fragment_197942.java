public class TestMap<KeyType, ValueType> {
    private Map<KeyType, ValueType> internalMap;

    public TestMap() {
        internalMap = new HashMap<KeyType, ValueType>();
    }

    public TestMap(Map<KeyType, ValueType> m) {
        internalMap = m;
    }

    public void printMap( String msg )
    {
        System.out.println( msg + ":" );
        Set<Map.Entry<KeyType,ValueType>> entries = internalMap.entrySet( );

        for( Map.Entry<KeyType,ValueType> thisPair : entries )
        {
            System.out.print( thisPair.getKey( ) + ": " );
            System.out.println( thisPair.getValue( ) );
        }
    }

    . . . // methods to add to internal map, etc.
}