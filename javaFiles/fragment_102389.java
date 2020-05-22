enum ThingColumn {
    id((t, rs, col) -> t.setId(rs.getLong(col))), 
    language((t, rs, col) ->t.setLanguage(rs.getString(col)));

    private ThingResultMapper mapper;

    ThingColumn(ThingResultMapper mapper){
        this.mapper = mapper;
    }

    public void map(Thing to, ResultSet from) {
        try {
            mapper.map(to, from, name());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}