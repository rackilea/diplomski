public class StringToListInt {
    private Map<String, List<Integer>> stringToListInt;

    public StringToListInt() {
        stringToListInt = new HashMap<String, List<Integer>>();
    }

    public void addInt( String string, Integer someValue ) {
        List<Integer> listInt = stringToListInt.get( string );
        if ( listInt == null ) {
            listInt = new ArrayList<String>();
            stringToListInt.put( string, listInt );
        }
        listInt.add( someValue );
    }

    public List<Integer> getInts( String string ) {
        return stringToListInt.get( string );
    }
}