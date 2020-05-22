public class MyNamedParameterJdbcTemplate extends NamedParameterJdbcTemplate {

    public MyNamedParameterJdbcTemplate(final DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public <T> T execute(final String sql, final Map<String, ?> paramMap, final PreparedStatementCallback<T> action) throws DataAccessException {
        final Map<String, Object> newParam = new HashMap<>();
        for (final Map.Entry<String, ?> entry : paramMap.entrySet()) {
            if (entry instanceof Enum<?>) {
                // param is an enum
                newParam.put(entry.getKey(), ((Enum) entry).toString());
            } else {
                newParam.put(entry.getKey(), entry.getValue());
            }
        }
        return super.execute(sql, newParam, action);
    }
}