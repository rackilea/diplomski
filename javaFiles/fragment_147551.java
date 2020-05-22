public class BigDecimalTypeHandler implements TypeHandler<BigDecimal> {
    public BigDecimal getResult(ResultSet rs, int columnIndex) throws SQLException{
        String str_val = rs.getString(columnIndex);
        BigDecimal res;

        if( str_val == null || str_val.equals("") )
            res = new BigDecimal(0);
        else
            res = new BigDecimal(str_val);

        return res;
    }
    public BigDecimal getResult(ResultSet rs, String columnName) throws SQLException{
        String str_val = rs.getString(columnName);
        BigDecimal res;

        if( str_val == null || str_val.equals("") )
            res = new BigDecimal(0);
        else
            res = new BigDecimal(str_val);

        return res;
    }
    public BigDecimal getResult(CallableStatement cs, int columnIndex) throws SQLException{
        String str_val = cs.getString(columnIndex);
        BigDecimal res;

        if( str_val == null || str_val.equals("") )
            res = new BigDecimal(0);
        else
            res = new BigDecimal(str_val);

        return res;
    }
    public void setParameter(PreparedStatement ps, int i, BigDecimal parameter, JdbcType jdbcType) throws SQLException{
        if( parameter != null )
            ps.setString(i, parameter.toString());
        else
            ps.setString(i, "0");
    }
}