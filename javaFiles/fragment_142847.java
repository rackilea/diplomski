public static String stripAccents(String s) 
{
    s = Normalizer.normalize(s, Normalizer.Form.NFD);
    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", ""); //remove all accents
    s = s.replaceAll( "(?i)e|i|c", "*" ); //replace e, i ,c with wildcard
    return s;
}