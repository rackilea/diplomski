@Autowired
private DataSource dataSource;

public void save (Dto dto) {
    Connection con = dataSource.getConnection();
    // finally, close the connection
}