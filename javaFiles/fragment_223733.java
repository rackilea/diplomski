/**
 * Escapes JS.
 */
public static String escapeJS(String value) {
    return StringEscapeUtils.escapeEcmaScript(value);
}