public static String[] mySplit(String str, String regex)
{
    Vector<String> result = new Vector<String>;
    int start = 0;
    int pos = str.indexOf(regex);
    while (pos>=start) {
        if (pos>start) {
            result.add(str.substring(start,pos));
        }
        start = pos + regex.length();
        result.add(regex);
        pos = str.indexOf(regex,start); 
    }
    if (start<str.length()) {
        result.add(str.substring(start));
    }
    String[] array = result.toArray(new String[0]);
    return array;
}