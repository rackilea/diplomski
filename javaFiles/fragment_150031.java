public List<Film> getFilmsFromResultSet(ResultSet rs) throws SQLException {
    List<Film> result = new ArrayList<>();

    while (rs.next()) {
        result.add(new Film(rs.getString("TITLE"), rs.getInt("LENGTH")));
    }

    return result;
}