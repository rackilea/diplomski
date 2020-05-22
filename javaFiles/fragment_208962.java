public static String escape(String str) {
    str = str.replace("\b", "\\b");
    str = str.replace("\t", "\\t");
    str = str.replace("\n", "\\n");
    str = str.replace("\r", "\\r");
    str = str.replace("\f", "\\f");
    str = str.replace("\'", "\\'");
    str = str.replace("\\", "\\\\");
    return str;
}