public static String getSQLFromDynamicQuery(SqlMapClient sqlMapClient,
        String queryId, Object paramObject) {

    // Gets the SQL and parameters.
    MappedStatement ms = ((SqlMapClientImpl) sqlMapClient).getDelegate()
            .getMappedStatement(queryId);
    RequestScope scope = new RequestScope();
    scope.setStatement(ms);
    String sql = ((DynamicSql) ms.getSql()).getSql(scope, paramObject);
    Object[] params = ms.getSql().getParameterMap(scope, paramObject)
            .getParameterObjectValues(scope, paramObject);

    // Adds params to the query.
    return bindQueryParam(sql, params);
}

public String getSQLFromStaticQuery(SqlMapClient sqlMapClient,
        String queryId, Object... params) {

    // Gets the SQL.
    String sql = ((StaticSql) ((SqlMapClientImpl) sqlMapClient)
            .getDelegate().getMappedStatement(queryId).getSql()).getSql(
            null, null);

    // Adds params to the query.
    if (params != null) {
        sql = bindQueryParam(sql, params);
    }

    return sql;
}

public static String bindQueryParam(String sql, Object... params) {
    String result = sql;
    for (Object param : params) {
        result = result.replaceFirst("\\?",
                param == null ? "null" : param.toString());
    }
    return result;
}