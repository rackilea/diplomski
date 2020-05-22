static boolean matches(String format, String data) {
    if (format.length() == 0 && data.length() == 0) {
        return true;
    }

    if (format.charAt(0) == '*' && format.charAt(1) != 0 && data.length() == 0) {
        return false;
    }

    if (format.charAt(0) == '?' || format.charAt(0) == data.charAt(0)) {
        return matches(format.substring(1), data.substring(1));
    }

    if (format.charAt(0) == '*') {

        return matches(format.substring(1), data) || matches(format, data.substring(1));
    }

    return false;
}