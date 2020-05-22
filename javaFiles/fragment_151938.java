private static String subString(String str, int freq) {
    //make it the right capacity to avoid reallocations
    StringBuilder subStr = new StringBuilder(str.length() / freq + 1);

    for (int i = 0; i < str.length(); i += freq) {
        subStr.append(str.charAt(i));
    }
    return subStr.toString();
}