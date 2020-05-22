private static final Pattern SINGLE_SEMICOLON = Pattern.compile(";");

public static Map<String, String> inflateStringToMap(String flatString) {
    return SINGLE_SEMICOLON.splitAsStream(flatString).
            collect(Collectors.toMap(keyMapper, valueMapper));
}