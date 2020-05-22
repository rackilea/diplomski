@Override
public Object resultToJava(FieldType fieldType, DatabaseResults results,
        int columnPos) throws SQLException {
    // remove the null check here so we can handle the null
    Object value = resultToSqlArg(fieldType, results, columnPos);
    return sqlArgToJava(fieldType, value, columnPos);
}