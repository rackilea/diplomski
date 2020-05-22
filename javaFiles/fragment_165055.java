static String enterADelimiter(String str, String delimiter, int after) {
        String regex = "(.{" + after +"})(?!$)";
        String replacement = "$1" + delimiter;

        return str.replaceAll(regex, replacement);
    }