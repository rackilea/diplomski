@Transactional
public class Test {
    @Autowired
    DataSource ds;

    public void test1() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("c1", "test");
        SimpleJdbcInsert insert = new SimpleJdbcInsert(ds).withTableName("t1").usingColumns("c1")
                .usingGeneratedKeyColumns("id");
        long id = insert.executeAndReturnKey(params).longValue();

    params = new HashMap<String, Object>();
    params.put("stuff", "stuff");
    params.put("id_fk", id);
    SimpleJdbcInsert insert2 = new SimpleJdbcInsert(ds).withTableName(
            "table2").usingColumns("stuff", "id_fk");
    insert2.execute(params);

        NamedParameterJdbcTemplate tmpl = new NamedParameterJdbcTemplate(ds);
        params = new HashMap<String, Object>();
        params.put("id", id);
        String c1 = tmpl.queryForObject("select c1 from t1 where id = :id", params, String.class);
    }