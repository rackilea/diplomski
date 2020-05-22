static Version byUrlElement(String urlElement) {
    for (Version version : Version.values()) {
        if (version.getUrlElement().equals(urlElement)) {
            return version;
        }
    }

    return null;
}