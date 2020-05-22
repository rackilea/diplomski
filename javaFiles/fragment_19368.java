public class NameValuePairRegex{

    public static void main( String[] args ){
        String SPACE = "\\s*";
        String EQ = "=";
        String OR = "|";

        /* The original regex tried by you (for comparison). */
        String orig = "(?<key>\\w+)\\s*=\\s*(?:[\\\"]?)(?<value>.+(?:(?=;)))";

        String key = "(?<key>\\w+)";
        String valuePatternForText = "(?:\")(?<valueT>((\")(?!;?$)|;(?!$)|[^;\"])+)\";?$";
        String valuePatternForNumbers = "(?<valueN>[^;\"]+);?$";
        String p = key + SPACE + EQ + SPACE + "(" + valuePatternForText + OR + valuePatternForNumbers + ")";

        Pattern nvp = Pattern.compile( p );
        System.out.println( nvp.pattern() );
        print( input(), nvp );
    }

    private static void print( List<String> input, Pattern ep ) {
        for( String e : input ) {
            System.out.println( e );
            Matcher m = ep.matcher( e );
            boolean found = m.find();
            if( !found ) {
                System.out.println( "\t\tNo match" );
                continue;
            }

            String valueT = m.group( "valueT" );
            String valueN = m.group( "valueN" );

            System.out.print( "\t\t" + m.group( "key" ) + " -> " + ( valueT == null ? "" : valueT ) + " " + ( valueN == null ? "" : valueN ) );
            System.out.println(  );
        }

    }

    private static List<String> input(){
        List<String> neg = new ArrayList<>();
        Collections.addAll( neg, 
                "Comment = \"This is a comment\";",
                "Comment = \"This is a comment with semicolon ;\";", 
                "Comment = \"This is a comment with semicolon ; and quote\"\";",
                "Comment = \"This is a comment\"", 
                "Comment = \"This is a \"comment\"; This is still a comment\";",
                "NumericValue = 123456;",
                "NumericValue = 123;456;",
                "NumericValue = 123\"456;",
                "NumericValue = 123456" );

        return neg;
    }

}