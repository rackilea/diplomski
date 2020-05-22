private static String replaceUnknownChars(String strWithUnknownChars, String fullStr) {
    StringBuilder sb = new StringBuilder(strWithUnknownChars);
    while ((int index = Math.max(sb.toString().indexOf('x'), sb.toString().indexOf('X'))) != -1) {
        sb.setCharAt(index, fullStr.charAt(index));
    }

    return sb.toString();
}