@Autowired
private DataSource dataSource;
//Further down 
Connection con=dataSource.getConnection();
DSLContext create = DSL.using(con, SQLDialect.MYSQL);
//Execute code here
con.close();