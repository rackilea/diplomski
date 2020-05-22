@Bean
public DataSource datasource() {
    System.out.println("in datasoure");
    return dataSource;
}

@Repository
public class EmployeeDAOImpl {
    @Autowired
    private Datasource datasource;

}