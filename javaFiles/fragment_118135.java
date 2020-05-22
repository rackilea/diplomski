public static String getQuery(String base, java.util.Map<String, String> map) {
    StringBuilder str = new StringBuilder(base);
    str.append('?');
    boolean first = true;
    for (java.util.Map.Entry<String, String> e : map.entrySet()) {
        if (first)
            first = false;
        else
            str.append('&');
        str.append(e.getKey());
        str.append('=');
        str.append(e.getValue());
    }
    return str.toString();
}