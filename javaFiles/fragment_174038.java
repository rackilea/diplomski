public static void main( String[] args ) {
    System.out.println( new BitStrings().generateBitStrings( new BigInteger( "2222", 3 ) ) );
}

public List<String> generateBitStrings( BigInteger maxValue ) {
    final String format = "%0" + maxValue.toString( 3 ).length() + "d";
    BigInteger current = BigInteger.ZERO;
    final List<String> result = new ArrayList<String>( maxValue.intValue() );
    do {
        result.add( String.format( format, Long.valueOf( current.toString( 3 ) ) ) );
        current = current.add( BigInteger.ONE );
    } while(current.compareTo( maxValue ) <= 0);
    return result;
}