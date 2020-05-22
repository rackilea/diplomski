class EscapedILikeExpression extends IlikeExpression {
    private static final String HIBERNATE_ESCAPE_CHAR = "\\";

    public EscapedILikeExpression(String propertyName, Object value) {
        super(propertyName, value);
    }

    public EscapedILikeExpression(String propertyName, String value, MatchMode matchMode) {
        super(propertyName, replaceAll(value), matchMode);
    }

    private static String replaceAll(String value) {
        return value
                .replace("\\",  HIBERNATE_ESCAPE_CHAR + "\\")
                .replace("_",   HIBERNATE_ESCAPE_CHAR + "_")
                .replace("%",   HIBERNATE_ESCAPE_CHAR + "%");

    }
}