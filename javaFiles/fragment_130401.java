public interface EnumWithNames {
    String getName();

    static <E extends EnumWithNames> E byName(Class<E> cls, String name) {
        for (E value : cls.getEnumConstants()) {
            if (Objects.equals(value.getName(), name)) return value;
        }
        throw new IllegalArgumentException("cannot identify " + cls.getName() + " value by name " + name);
    }
}

public enum Condition implements EnumWithNames {
    private String name;
    ...

    @Override
    public String getName() { return name; }
}