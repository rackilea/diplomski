public class CustomizedObjectMapper implements ResultSetMapper<customizedObject> {

    @Override
    public customizedObject map(int index, ResultSet r, StatementContext ctx)
            throws SQLException {
        return new customizedObject(r.getString("uuid"), r.getString("other_column"));
    }

}