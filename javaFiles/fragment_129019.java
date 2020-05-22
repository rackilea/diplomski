public <T> List<T> getParsableDTOs(String table, RowMapper<T> mapper) {
    try (ResultSet rs = doQueryWithReturn(StringQueryComposer
            .createLikeSelectQuery(table, null, null, null, true))) {
        List<T> rtn_lst = new ArrayList<T>();
        while(rs.next()) {
            rtn_lst.add(mapper.mapRow(rs));
        }
        return rtn_lst;
    } catch (SQLException e) {
        // ...
    }

    return rtn_lst;
}