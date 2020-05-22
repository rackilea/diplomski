public static String formatString(String string) {
    String result = string;
    result = result.replace('\u00F7', '/'); 
    result = result.replace('\u00D7', '*'); 
    return result;
}