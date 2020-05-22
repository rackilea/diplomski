public static boolean validateString(String input) {
    if (input.split(":").length != 4) {
        return false;
    }
    for (String info : input.split(":")) {
        if (info.length() == 0) {
            return false;
        }
    }
    return true;
}