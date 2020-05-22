// Generate the HTML to report on the details of a `person` from the database, given the UUID of that database row.
private String renderHtml ( UUID uuid ) {
    String eol = "\n"; // End-of-line character(s) to use in the HTML.
    StringBuilder html = new StringBuilder();
    html.append( "<!DOCTYPE html>" ).append( eol );
    html.append( "<html>" ).append( eol );
    html.append( "<head>" ).append( eol );
    html.append( "<title>Person</title>" ).append( eol );
    html.append( "</head>" ).append( eol );
    html.append( "<body style='color:DarkSlateGray' >" ).append( eol );
    html.append( "<h1>Demo</h1>" ).append( eol );
    html.append( "<p>This is a drill. This is only a drill.</p>" ).append( eol );
    html.append( "<p>If this had been a real application, you would have seen some data.</p>" ).append( eol );
    html.append( "<p>Person ID: " ).append( uuid.toString() ).append( ".</p>" ).append( eol );
    html.append( "<p style='color:DimGray ; font-family: Pragmata Hack Menlo monospaced' >Report generated " ).append( Instant.now() ).append( ".</p>" ).append( eol );
    html.append( "</body>" ).append( eol );
    html.append( "</html>" ).append( eol );
    String s = html.toString();
    return s;
}