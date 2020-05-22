public MapSqlParameterSource addValue(String paramName, Object value) {
    Assert.notNull(paramName, "Parameter name must not be null");
    this.values.put(paramName, value);
    if (value instanceof SqlParameterValue) {
        registerSqlType(paramName, ((SqlParameterValue) value).getSqlType());
    }
    return this;
}