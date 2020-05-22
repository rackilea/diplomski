public static float myParseFloat(String str) {
    int firstDot = str.indexOf('.');
    if (firstDot != -1) {
        int secondDot = str.indexOf('.', firstDot+1);
        return Float.parseFloat(secondDot == -1 ? str : str.substring(0,secondDot));
    }
    return Float.parseFloat(str);
}