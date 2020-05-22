private static Pattern pat = Pattern.compile( "page=(\\d+)&items=(\\d+)" );
private static boolean check( String s ){
Matcher mat = pat.matcher( s );
return mat.matches() &&
    (Integer.valueOf( mat.group(1) ) - 1)*200 ==
    Integer.valueOf( mat.group(2) );
}