public enum Gender {

    m("male"), f("female");

    private final String value;

    private static final Map<String, Gender> values = new HashMap<String, Gender>();
    static {
        for (Gender g : Gender.values()) {
            if (values.put(g.value, g) != null) {
                  throw new IllegalArgumentException("duplicate value: " + g.value);
            }
        }
    }

    private Gender(String option) {
          value = option;
    }

    public static Gender fromString(String option) {
        return values.get(option);
    }
}