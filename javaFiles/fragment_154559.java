public class MyWriter implements ItemWriter<MyObject> {
    private JdbcItemWriter<MyObject> writer1;
    private JdbcItemWriter<MyObject> writer2;

    @PostConstruct
    public void afterPropertiesSet() {
         writer1 = new JdbcItemWriter<MyObject>();
         writer1.set...
         writer1.afterPropertiesSet();

         writer2 = ... same thing

    }

    public void write(List<MyObject> items) {
         writer1.write(items);

         List<MyObject> reReadItems = 
                new JdbcTemplate(datasource)
                   // you could use a row that which has a unique chunk id
                   // or you could construct a query with an appropriate
                   // in-Clause... however, the size of possible in-clauses
                   // is limited, for instance oracle has 1000
                   .query(a query that selects only the entries you inserted above,
                (resultset, row) -> // RowMapper
                { 
                    MyObject obj = new MyObject();
                    obj.setXy(resultset.get...);
                    ...
                    return obj;
                 });
          writer2.write(reReadItems);
    }
}