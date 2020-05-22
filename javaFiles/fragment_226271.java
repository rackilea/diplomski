public enum CountryCode {

    AD("Andorra", "AND", "Europe", "South West Europe"),
    AE("United Arab Emirates", "ARE", "Asia", "South West Asia"),
    AF("Afghanistan", "AFG", "Asia", "South Asia");

    private static final Map<String, CountryCode> BY_LABEL;
    static {
        Map<String, CountryCode> byLabel = new HashMap<String, CountryCode>();
        for (CountryCode countryCode : values()) {
            byLabel.put(countryCode.label, countryCode);
        }
        BY_LABEL = Collections.unmodifiableMap(byLabel);
    }

    private final String label;
    private final String isoCode3;
    private final String continent;
    private final String region;

    private CountryCode(String label, String isoCode3, String continent, String region) {
        this.label = label;
        this.isoCode3 = isoCode3;
        this.continent = continent;
        this.region = region;
    }

    public static CountryCode getByLabel(String label) {
        return BY_LABEL.get(label);
    }

}