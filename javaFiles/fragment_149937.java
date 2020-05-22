@Autowired
private DatabaseService databaseService;

@Test
public void testInsertData() {
    ...........
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
     assertEquals(1, databaseService.insertData(datetime, days_rolling, host, start_or_stop, scenario_threadpool_size, days_rolling_weighted));
            ...........
        }