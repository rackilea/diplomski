private static String[] reverseMany(String[] strings) {
    String[] result = new String[strings.length];
    for (int j = 0; j < strings.length; ++j) {
        result[j] = reverseString(strings[j]);
    }
    return result;
}