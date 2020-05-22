public static void main(String[] args) {
    String[] strs = new String[] { "Foo", "Bar", "Baz" };

    String joined = Arrays.toString( strs );

    String joinedMinusBrackets = joined.substring( 1, joined.length() - 1);

    // String.split()
    String[] resplit = joinedMinusBrackets.split( ", "); 

    for ( String s : resplit ) {
        System.out.println( s );
    }

}