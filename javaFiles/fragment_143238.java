public static void main(String[] args)
{

    String pattern = "http[s]*://[a-z0-9-]{1,}\\.[a-z0-9-]{1,}\\.com/([a-z0-9-_%\\?\\=]{1,}/)*[a-zA-Z0-9_-]{1,}\\.html#[a-zA-Z_\\-\\.]{1,}";

    String string = "http://docs.oracle.com/javase/8/docs/api/java/lang/String.html#matches-java.lang.String-";

    /*
     * This will print the boolean literal true or false
     */
    System.out.println( string.matches(pattern) );

}