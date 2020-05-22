private static String toLowerCase(String str) {
    StringBuilder sb = new StringBuilder(str.length());
    for (int i = 0; i < str.length(); i++) {
        if (Character.isUpperCase(str.charAt(i))) {
            sb.append (Character.toLowerCase(str.charAt(i)));
        } else {
            sb.append (str.charAt(i));
        }
    }
    return sb.toString();
}