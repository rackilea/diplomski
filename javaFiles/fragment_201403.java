class Replacer {
    static Pattern isPattern = Pattern.compile("...(is)..."); // here you have to figure out the right pattern

    public static String notReplace(String input) {
        return isPattern.matcher(input).replaceAll("is not");
    }
}