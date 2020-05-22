public static String ReverseString(String str) {
    String strReverse = "";
    if ("".equals(str)) {
        return strReverse;
    }

    if (str.length() == 1) {
        return str;
    }
    else {
        strReverse += str.charAt(str.length()-1) +
            ReverseString(str.substring(0,str.length()-1));
        return strReverse;
    }
}