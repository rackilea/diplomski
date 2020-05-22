String htmlText = "<span id=\"lblObject\"><a href=\"http://www.guideline.gov/content.aspx?id=15135\" alt=\"View object\">Manual medicine guidelines for musculoskeletal injuries.</a></span>";
    Pattern pattern = Pattern.compile( "href=\"(http://www.guideline.gov/content.aspx\\?id=.*?)\"" );

    Matcher matcher = pattern.matcher( htmlText );
    while ( matcher.find() )
    {
        String matchedText = matcher.group( 0 );
        Pattern p = Pattern.compile("href=\"(.*?)\"");
        Matcher m = p.matcher(matchedText);
        String url = null;
        if (m.find()) {
            url = m.group(1);
            System.out.println(url);
        }
    }

// output : http://www.guideline.gov/content.aspx?id=15135