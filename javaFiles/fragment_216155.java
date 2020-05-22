private static final StringBuffer appendParsedText( StringBuffer parsedText, String snippet )
{
    if ( parsedText.length() > 0 )
    {
        return parsedText.append( ", " + snippet );
    }
    return parsedText.append( snippet );
}

public static final String parseAccess( final String text )
{
    StringBuffer parsedText = new StringBuffer();

    if ( text.contains( "string1" ) )
    {
        parsedText = appendParsedText( parsedText, "string1" );
    }

    if ( text.contains( "string2" ) )
    {
        parsedText = appendParsedText( parsedText, "string2" );
    }

    if ( text.contains( "string3" ) )
    {
        parsedText = appendParsedText( parsedText, "string3" );
    }

    return parsedText.toString();
}