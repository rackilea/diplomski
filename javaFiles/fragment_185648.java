public class SomeDaoImpl implements SomeDao {
    private final JdbcTemplate jdbcTemplateA;
    private final JdbcTemplate jdbcTemplateB;

    @Autowired
    public SomeDaoImpl(JdbcTemplate jdbcTemplateA, JdbcTemplate jdbcTemplateB) {
        // injecting both JdbcTemplate instances
        this.jdbcTemplateA = jdbcTemplateA;
        this.jdbcTemplateB = jdbcTemplateB;
    }

    public void businessLogicMethod(...) {
        // choosing the actual template to be used according to your logic
        JdbcTemplate jdbcTemplate = chooseTemplate(...);
        // now using the template to execute a query
        jdbcTemplate.execute(...);
    }
}