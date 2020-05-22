@Autowired 
public MyClass(DataSource dataSource) {
    super();
    setDataSource(dataSource);
}

@Autowired 
public void setDs(DataSource dataSource) {
    setDataSource(dataSource);
}