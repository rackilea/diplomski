MysqlDataSource ds = new MysqlDataSource();
ds.setServerName("host");
ds.setUser("user");
ds.setPassword("password");

JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);

BufferedReader in = new BufferedReader(new FileReader("script.sql"));
LineNumberReader fileReader = new LineNumberReader(in);
String query = JdbcTestUtils.readScript(fileReader);