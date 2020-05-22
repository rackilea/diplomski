public static void main( String[] args )
{
    String inputMessage = "The {def1} in {def2} stays mainly in the {def3}.";
    String result = CustomMessageFormat.format( inputMessage, new Object[] { "sun", "Paris", "suburbs" } );
    System.out.println( result );
}