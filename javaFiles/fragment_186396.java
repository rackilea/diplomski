enum IdType {

    DRIVING_LICENCE,
    ID_CARD,
    PASSPORT;

    private static Map<String, IdType> mapping = new HashMap<>();

    static {
        mapping.put("drivingLicence", DRIVING_LICENCE);
        mapping.put(DRIVING_LICENCE.name(), DRIVING_LICENCE);
        // ...
    }

    @JsonCreator
    public static IdType fromString(String value) {
        return mapping.get(value);
    }
}