public class DBConection extends SimpleJdbcDaoSupport implements ElectionsDao{
    public List<String> getDates(){
        List<String> dates = new ArrayList<String>();
        try {
            dates = getSimpleJdbcTemplate().query("SELECT electiondate FROM electiondate";, new StringRowMapper());
        } catch (DataAccessException ex){
        throw new RuntimeException(ex);
        }
        return dates;
    }

    protected static final class StringRowMapper implements ParameterizedRowMapper<String> {
        public String mapRow(ResultSet rs, int line) throws SQLException {
            String string = new String(rs.getString("electiondate"));
            return string;
        }
    }
}