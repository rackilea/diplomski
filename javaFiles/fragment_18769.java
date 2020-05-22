private final JdbcTemplate jdbcTemplate;

@Autowired
public YourRepository(DataSource ds) {
    this.jdbcTemplate=new JdbcTemplate(ds);
}

public List<User> getAllUsers() {
    List<User> list = new ArrayList<>();
    return this.jdbcTemplate("select * from V_USERS t", new RowMapper() {
        public User mapRow(ResultSet rs, int row) throws SQLException {
            return RowFetcher.fetchUser(rs);
        }
    });
}