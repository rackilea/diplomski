public void updateRow(Value[] current, Value[] updateRow) throws SQLException {
    StatementBuilder buff = new StatementBuilder("UPDATE ");
    ...
    buff.append(" SET ");
    appendColumnList(buff, true);
    ...
    appendKeyCondition(buff);
    PreparedStatement prep = conn.prepareStatement(buff.toString());
    ...
    for (int i = 0; i < columnCount; i++) {
       ...
        v.set(prep, j++);
    }
    setKey(prep, j, current);
    int count = prep.executeUpdate();
    ...
}