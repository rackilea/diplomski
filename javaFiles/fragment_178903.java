public class CustomMessageFormat
{
    public static String format( String message, Object[] params )
    {
        Pattern pattern = Pattern.compile( "\\{(.*?)\\}" );
        Matcher matcher = pattern.matcher( message );
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while ( matcher.find() )
        {
            matcher.appendReplacement( sb, "{" + ( i++ ) + "}" );
        }
        matcher.appendTail( sb );

        return MessageFormat.format( sb.toString(), params );
    }
}