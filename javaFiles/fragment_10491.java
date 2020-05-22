public class ListArgumentFactory implements ArgumentFactory<List> {
    @Override
    public boolean accepts(Class<?> expectedType, Object value, StatementContext ctx) {
        return value instanceof List;
    }

    @Override
    public Argument build(Class<?> expectedType, final List value, StatementContext ctx) {
        return new Argument() {
            @Override
            public void apply(int position, PreparedStatement statement, StatementContext ctx) throws SQLException {
                String type = null;
                if(value.get(0).getClass() == String.class){
                    type = "varchar";
                } else if(value.get(0).getClass() == Integer.class){
                    // For integer and so on...
                } else {
                    // throw error.. type not handled
                }
                Array array = ctx.getConnection().createArrayOf(type, value.toArray());
                statement.setArray(position, array);
            }
        };
    }
}