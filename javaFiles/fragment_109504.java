public class Null2DateTypeHandler implements TypeHandler<Date> {

    @Override
    public void setParameter(PreparedStatement ps, int i, java.util.Date parameter, JdbcType jdbcType) throws SQLException {
        System.err.println(String.format("ps: %s, i: %d, param: %s, type: %s", ps.toString(), i, parameter, jdbcType.toString()));

        if (parameter == null) {
            ps.setDate(i, null); // ??? I'm not sure. But it works.
        } else {
            ps.setDate(i, new java.sql.Date(parameter.getTime()));
        }
    }
}