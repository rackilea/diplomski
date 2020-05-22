CqlTemplate-> processOne()

@SuppressWarnings("unchecked")
@Override
public <T> T processOne(ResultSet resultSet, Class<T> requiredType) throws DataAccessException {
    if (resultSet == null) {
        return null;
    }
    Row row = resultSet.one();
    if (row == null) {
        return null;
    }
    return (T) firstColumnToObject(row);
}