// May contain simple syntax error, I don't have java right now to test..
// but this is a bigger picture for your algo...
public String localeToString(Locale l) {
    return l.getLanguage() + "," + l.getCountry();
}

public Locale stringToLocale(String s) {
    StringTokenizer tempStringTokenizer = new StringTokenizer(s,",");
    if(tempStringTokenizer.hasMoreTokens())
    String l = tempStringTokenizer.nextElement();
    if(tempStringTokenizer.hasMoreTokens())
    String c = tempStringTokenizer.nextElement();
    return new Locale(l,c);
}