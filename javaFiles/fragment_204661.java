public class CustomRowMapper implements RowMapper<YourClass> {

    @Override
    public YourClass mapRow(ResultSet rs, int rowNum) throws SQLException {
        String columnXYZ = rs.getString("yourColumnName");
        //check input etc..

    }
}