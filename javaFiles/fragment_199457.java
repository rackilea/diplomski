ResultSetMetaData rsmd = rs.getMetaData();
int type = 0;

for (int i = 1; i <= rsmd.getColumnCount(); i++) {
    type = rsmd.getColumnType(i);
    switch (type) {
        case Types.SMALLINT:
            break;
        case Types.INTEGER:
            break;
        case Types.BIGINT:
            break;
        case Types.DECIMAL:
            break;
        case Types.NUMERIC:
            break;
        case Types.FLOAT:
            break;
        case Types.DOUBLE:
            break;
        default:
    }
}