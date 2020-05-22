private static final Map<String, Version> VERSION_INDEX = new HashMap<>();

static {
    for (Version version : Version.values()) {
        VERSION_INDEX.put(version.getUrlElement(), version);
    }
}