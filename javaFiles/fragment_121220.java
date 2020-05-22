@Autowired
private DataSource dataSource;

private JdbcTemplate jdbcTemplate;

@PostConstruct
private void init() {
    jdbcTemplate = new JdbcTemplate(dataSource);
    System.out.println("jdbTemplate created");
}

public void getCount2() {
   String sql= "SELECT COUNT(*) FROM MYTABLE";
   int count = jdbcTemplate.queryForInt(sql);
   System.out.println("Count = " + count);
}