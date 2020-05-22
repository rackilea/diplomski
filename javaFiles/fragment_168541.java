public class PersonNameTypeHandler extends BaseTypeHandler<String> {
    ...
    @Override
    public String getNullableResult(ResultSet rs, String columnName) {
        return rs.getString(2);
    }
    ...
}