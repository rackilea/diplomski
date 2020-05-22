public static String replaceWithNumbers( String text, String match ) {
    int matchLength = match.length();
    StringBuilder sb = new StringBuilder( text );

    int index = 0;
    int i = 1;
    while ( ( index = sb.indexOf( match, index )) != -1 ) {
        String iStr = String.valueOf(i++);
        sb.insert( index + matchLength, iStr );

        // Continue searching from the end of the inserted text
        index += matchLength + iStr.length();
    }

    return sb.toString();
}