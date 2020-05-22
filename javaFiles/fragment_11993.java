public class JdbcUserDAO {

    private static final String TERM_USER_SQL = "UPDATE USER "
            + "SET TERM_DATE = date('now') WHERE USER_NAME = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcUserDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void terminateUser(String userName) {
        jdbcTemplate.update(TERM_USER_SQL, userName);
    }

}