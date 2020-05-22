private final JdbcTemplate jdbcTemplate;

 @Autowired
 public MyController(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
 }