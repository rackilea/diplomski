// use jdbcTemplate1 for login/register/information
@Autowired
@Qualifier("jdbc1")
protected JdbcTemplate jdbcTemplate1;

// use jdbcTemplate2 for other
@Autowired
@Qualifier("jdbc2")
protected JdbcTemplate jdbcTemplate2;