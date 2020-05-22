private static String replaceAllTags(String message, Map< String, String > tags)
{
    StringBuilder sb = new StringBuilder( message );
    boolean tagFound = false;
    /**
     * prevent endless circular text replacement loops
     */
    long recurrancyChecker = 5000;

    do
    {
        tagFound = false;
        Iterator it = tags.entrySet().iterator();
        while( it.hasNext() )
        {
            Map.Entry pairs = (Map.Entry) it.next();

            int start = sb.indexOf( pairs.getKey().toString() );

            while( start > -1 && --recurrancyChecker > 0 )
            {
                int length = pairs.getKey().toString().length();
                sb.replace( start, start + length, pairs.getValue().toString() );
                start = sb.indexOf( pairs.getKey().toString() );
                tagFound = true;
            }
        }
    }
    while( tagFound && --recurrancyChecker > 0 );
    return sb.toString();
}