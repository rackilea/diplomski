static String update( String str, String upd ){
    // split to get the keyword and the value
    String[] kwv = upd.split( "=" );
    // compose the regex
    String regex = "(?<=^|&)" + Pattern.quote(kwv[0]) + "=\\d+";
    return str.replaceAll( regex, upd );
}