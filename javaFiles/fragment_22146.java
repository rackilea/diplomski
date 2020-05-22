Cursor getHousesFromDatabase(String owner, String city, Integer size) {
    String[] params = new String[(owner != null ? 1 : 0) +
                                 (city  != null ? 1 : 0) +
                                 (size  != null ? 1 : 0)];
    int paramIndex = 0;
    String where = "";
    if (owner != null) {
        where = COLUMN_OWNER + " LIKE ?";
        params[paramIndex++] = owner + "%";
    }
    if (city != null) {
        if (!where.equals(""))
            where = where + " AND ";
        where = where + COLUMN_CITY + " LIKE ?";
        params[paramIndex++] = city + "%";
    }
    if (size != null) {
        if (!where.equals(""))
            where = where + " AND ";
        where = where + COLUMN_SIZE + " LIKE ?";
        params[paramIndex++] = size + "%";
    }
    return db.query(TABLE_HOUSES, columns, where, params, null, null, null);
}