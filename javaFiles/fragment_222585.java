class TypePropertySource extends PropertySource<TypeSource> {
    private final TypeSource source;

    TypePropertySource(final TypeSource source) {
        super("a-name", source);
        this.source = source;
    }

    @Override
    public Object getProperty(final String name) {
        try {
            return (Type) source.getAndDeserialize(name);
        } catch (final Exception e) {
            // Recover or do nothing.
        }

        return null;
    }
}