if (preparedStatement instanceof PreparedStatementSpy) {
    Method m = PreparedStatementSpy.class.getDeclaredMethod("dumpedSql");
    m.setAccessible(true);
    usedSql = (String) m.invoke(preparedStatement);
}
// omitted exception handling