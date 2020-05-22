public static void main(String[] args) {
    String[] strs = new String[] { "Foo", "Bar", "Baz" };

    String joined = Arrays.toString( strs );

    String joinedMinusBrackets = joined.substring( 1, joined.length() - 1);

    // Guava Splitter class
    List<String> resplitList = Splitter.on( ", " ).splitToList( joinedMinusBrackets );

    for ( String s : resplitList ) {
        System.out.println( s );
    }
}