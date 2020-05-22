/**
 * Retrieves the value from the designated column as an {@link Integer}
 * object.
 * 
 * @param rs
 *            The ResultSet to read from.
 * @param columnName
 *            The column name to read.
 * @return {@code null} if the column value was SQL NULL; its value as an
 *         integer otherwise.
 */
public static Integer getInteger(ResultSet rs, String columnName) {
    int v = rs.getInt(columnName);
    return rs.wasNull() ? null : v;
}