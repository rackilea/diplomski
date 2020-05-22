@FunctionalInterface
static interface ResultGetter<T> {
    T get(ResultSet from, String column) throws SQLException;
}

enum ThingColumn {
    id(ResultSet::getLong, Thing::setId), 
    language(ResultSet::getString, Thing::setLanguage);

    private final BiConsumer<Thing, ResultSet> mapper;

    <T> ThingColumn(ResultGetter<T> getter, BiConsumer<Thing, T> setter) {
        this.mapper = (t, rs) -> {
            try {
                setter.accept(t, getter.get(rs, name()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public void map(Thing to, ResultSet from) {
        this.mapper.accept(to, from);
    }
}