String trim() {
    byte[] b = getBytes();
    ...
    return new String(b, 0, len);
}

String replaceAll (String needle, String replacement) {
    String result = "";
    int pos = 0;
    while (indexOf(needle, pos) != -1) {
        ...
        result = result + replacement;
        pos = ...;
    }
    return result;
}