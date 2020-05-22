public static String getNumbers(String s) {
    String result = new String();

    for (int i = 0; i < s.length(); i++) {
        if (Character.isLetter(s.charAt(i))) {
            result += getNumber(Character.toUpperCase(s.charAt(i)));
            result += "-";
        }
        else {
            result += s.charAt(i);
        }
    }
    return result.substring(0, result.length() - 1);
}