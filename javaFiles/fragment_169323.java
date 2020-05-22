private static boolean isQuoted(boolean noQuotesInside, String arg,
        String errorMessage) {
    int lastPos = arg.length() - 1;
    if (lastPos >=1 && arg.charAt(0) == '"' && arg.charAt(lastPos) == '"') {
        // The argument has already been quoted.
        if (noQuotesInside) {
            if (arg.indexOf('"', 1) != lastPos) {
                // There is ["] inside.
                throw new IllegalArgumentException(errorMessage);
            }
        }
        return true;
    }
    if (noQuotesInside) {
        if (arg.indexOf('"') >= 0) {
            // There is ["] inside.
            throw new IllegalArgumentException(errorMessage);
        }
    }
    return false;
}