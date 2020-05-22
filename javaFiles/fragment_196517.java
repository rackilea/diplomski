public void createSQLReportItem(MappedStatement ms) {
    BoundSql boundSql = ms.getBoundSql(originalRec);
    List<ParameterMapping> params = boundSql.getParameterMappings();

    finalSql = boundSql.getSql();
    finalSql = finalSql.replaceAll("\\s", " ");
    finalSql = finalSql.replaceAll("[ ]{2,}", " ");

    for (ParameterMapping pm : params) {
        if (paramMapping.containsKey(pm.getProperty())) {
            finalSql = finalSql.replaceFirst("\\?", paramMapping.get(pm.getProperty()));
        }
    }
}