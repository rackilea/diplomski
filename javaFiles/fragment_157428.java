private static String convertToken(String index, String flags, String width, String precision, String temporal, String conversion) {
    if (conversion.equals("s")) {
        return "[\\w\\d]*";
    } else if (conversion.equals("d")) {
        return "[\\d]{" + width + "}";
    }
    throw new IllegalArgumentException("%" + index + flags + width + precision + temporal + conversion);
}