interface TypeX {
    String getType();
    static <T extends Enum<T>&TypeX> T fromValue(String value, Class<T> type) {
        EnumSet<T> all=EnumSet.allOf(type);
        for (T t: all) {
            if (t.getType().equalsIgnoreCase(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException(all.stream().map(t -> t.getType())
            .collect(Collectors.joining(", ",
                value+" is an invalid value. Supported values are ", "")));
    }
}

public enum TypeA implements TypeX {
    ValueAA ("Value AA"),
    ValueAB ("Value AB");

    private final String type;

    TypeA (final String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return this.type;
    }

    @JsonCreator
    public static TypeA fromValue(final String value) {
        return TypeX.fromValue(value, TypeA.class);
    }
}

enum TypeB implements TypeX {
    ValueBA ("Value BA"),
    ValueBB ("Value BB");

    private final String type;

    TypeB (final String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return this.type;
    }

    @JsonCreator
    public static TypeB fromValue(final String value) {
        return TypeX.fromValue(value, TypeB.class);
    }
}