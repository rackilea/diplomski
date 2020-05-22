public static String[] toStringArr(StringBuffer sb[]) {
    if (sb == null) return null;
    String str[] = new String[sb.length];
    for (int i = 0; i < sb.length; i++) {
        if (sb[i] != null) {
            str[i] = sb[i].toString();
        }
    }
    return str;
}