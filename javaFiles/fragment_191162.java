private static Pattern p = Pattern.compile("<td>(.+?)</td>");

public static String getName(String in) {
    Matcher m = p.matcher(in);

    for (i=0; i<1 && m.find(); i++);

    if (i==0) {
        return null;
    } else {
        return m.group(1);
    }
}