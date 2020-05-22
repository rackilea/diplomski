private static String removeNumbers(String s) {
    return s.replaceAll("\\d", "");
}

private static Integer keepNumbers(String s) {
    String number = s.replaceAll("\\D", "");
    if (!number.isEmpty()) {
        return Integer.parseInt(number);
    }
    return 0;
}