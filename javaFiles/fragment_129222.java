class MyEnumTransform implements Transform<Enum> {
    private final Class type;

    public MyEnumTransform(Class type) {
        this.type = type;
    }

    public Enum read(String value) throws Exception {
        for (Object o : type.getEnumConstants()) {
            if (o.toString().equals(value)) {
                return (Enum) o;
            }
        }
        return null;
    }

    public String write(Enum value) throws Exception {
        return value.toString();
    }
}