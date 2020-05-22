private String getResultSetTypeName(int resultSetType) {
    switch (resultSetType) {
    case ResultSet.TYPE_FORWARD_ONLY:
        return "TYPE_FORWARD_ONLY";
    case ResultSet.TYPE_SCROLL_INSENSITIVE:
        return "TYPE_SCROLL_INSENSITIVE";
    case ResultSet.TYPE_SCROLL_SENSITIVE:
        return "TYPE_SCROLL_SENSITIVE";
    default:
        throw new IllegalArgumentException("Invalid result set type value: " + resultSetType);
    }
}