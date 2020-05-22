static void load(Object target, ResultSet rs) throws Exception {
    Class<?> clazz = target.getClass();

    ResultSetMetaData rsmd = rs.getMetaData();
    for (int i=0; i<rsmd.getColumnCount(); i++) {
        Field field = clazz.getDeclaredField(rsmd.getColumnName(i+1));
        field.setAccessible(true);
        int type = rsmd.getColumnType(i+1);
        switch (type) {
            case Types.DATE: {
                field.set(target, rs.getDate(i+1));
            }
            case Types.VARCHAR: {
                field.set(target, rs.getString(i+1));
            }
            case Types.BIGINT: {
                field.set(target, rs.getInt(i+1));
            }
            default: {
                throw new IllegalArgumentException(
                   "Unhandled field type: " + type);
            }
        }
    }
}