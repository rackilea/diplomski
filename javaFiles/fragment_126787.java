Pattern dtPatt = Pattern.compile( "(\\d\\d\\d\\d)[/\\-.](\\d\\d)[/\\-.](\\d\\d)[tT/\\-.](\\d\\d)[:.](\\d\\d)[:.](\\d\\d)" );
    Matcher m = dtPatt.matcher( str );

    if ( m.matches() )
    {
        StringBuffer sb = new StringBuffer();
        m.appendReplacement( sb, "$1/$2/$3-$4:$5:$6" );

        String result = sb.toString();
    }
    else
    {
        System.out.println( "Error!  Bad date/time entry." );
    }