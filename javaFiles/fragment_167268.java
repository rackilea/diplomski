private static boolean testInteger(String str) {
    try {
        int d = Integer.parseInt(str);
    } catch (NumberFormatException e) {
        return false;
    }
    return true;
}