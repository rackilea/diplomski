public static boolean stringIsBlank(String stringValue) {
    if (stringValue != null) {
        return stringValue.trim().length() <= 0;
    } else {
        return true;
    }
}