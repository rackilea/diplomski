public static int contains (String s1, String s2) {
    Pattern p = Pattern.compile(s2+"(?!.*"+s2+")");
    Matcher m = p.matcher(s1);

    if(m.find())
        return m.start();

    return -1;
}