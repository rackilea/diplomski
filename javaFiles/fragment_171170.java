public String method(String str) {
    if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == 'x') {
        str = str.substring(0, str.length() - 1);
    }
    return str;
}