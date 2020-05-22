public final class StateUtils {

    private static final StateResolver STATE_RESOLVER = new EnumStateResolver();
    private static final String OPTION_FORMAT = "<option value=\"%1$s\">%1$s</option>\n";

    public static String createStateSelectList() {
        final StringBuilder sb = new StringBuilder();
        sb.append("<select name=\"state\">\n");
        for (final State s : STATE_RESOLVER.getAllStates()) {
            sb.append(String.format(OPTION_FORMAT, s.fullName()));
        }
        sb.append("</select>\n");
        return sb.toString();
    }

    public static String parseSelectedState(final String s) {
        return STATE_RESOLVER.fromFullName(s).shortName();
    }

    public static String displayStateFullName(final String abbr) {
        return STATE_RESOLVER.fromShortName(abbr).fullName();
    }
}