public Position extractData(ResultSet rs) throws SQLException,
            DataAccessException {
        Position p = new Position();
        if(rs.next()) {
            p.setId(rs.getString("id"));
            p.setPositionName(rs.getString("position_name"));
            p.setDescription(rs.getString("description"));
        }
        return p;
}