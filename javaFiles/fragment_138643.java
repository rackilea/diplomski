public static String difference(String str1, String str2) {
    int at = indexOfDifference(str1, str2);
    if (at == -1) {
        return "";
    }
    return str2.substring(at,at+1);
}