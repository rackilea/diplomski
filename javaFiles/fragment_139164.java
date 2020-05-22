public static String replaceLastFour(String s) {
    int length = s.length();
    //Check whether or not the string contains at least four characters; if not, this method is useless
    if (length < 4) return "Error: The provided string is not greater than four characters long.";
    return s.substring(0, length - 4) + "****";
}