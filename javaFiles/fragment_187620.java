public class MyCustomWriter<T> extends JdbcBatchItemWriter<T> {

    @Override
    public void write(List<? extends T> items) throws Exception {
        namedParameterJdbcTemplate.getJdbcOperations().batchUpdate("your sql", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                // set values on your sql
            }

            @Override
            public int getBatchSize() {
                return items.size(); // or any other value you want
            }
        });
    }

}