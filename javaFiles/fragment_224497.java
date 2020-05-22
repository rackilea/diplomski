public enum Version {
    VERSION_2_0("v2.0"),
    VERSION_2_1("v2.1"),
    VERSION_2_2("v2.2");

    String value;

    Version(String value) {
        this.value = value;
    }

    static Version byValue(String value) {
        for (Version version : Version.values()) {
            if (version.value.equals(value)) {
                return version;
            }
        }

        return null;
    }
}