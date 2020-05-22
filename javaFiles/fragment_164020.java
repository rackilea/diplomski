private static String getSuffix(String token, int i) {
        if (i <= token.length()) {
            return token.substring(token.length() - i, token.length());
        }
        return null;
    }