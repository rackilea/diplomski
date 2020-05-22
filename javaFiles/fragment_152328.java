interface TypeX {
    @Retention(RetentionPolicy.RUNTIME) @interface Type { String value(); }

    @JsonValue default String getType() {
        for(Field f: getDeclaringClass().getDeclaredFields()) try {
            if(f.isEnumConstant() && f.get(null)==this) {
                return f.getAnnotation(Type.class).value();
            }
        } catch(IllegalAccessException ex) {
            throw new AssertionError(ex);
        }
        throw new IllegalStateException();
    }

    Class<? extends TypeX> getDeclaringClass();

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
    @Type("Value AA") ValueAA,
    @Type("Value AB") ValueAB;

    @JsonCreator
    public static TypeA fromValue(final String value) {
        return TypeX.fromValue(value, TypeA.class);
    }
}

enum TypeB implements TypeX {
    @Type("Value BA") ValueBA,
    @Type("Value BB") ValueBB;

    @JsonCreator
    public static TypeB fromValue(final String value) {
        return TypeX.fromValue(value, TypeB.class);
    }
}