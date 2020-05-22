@Component("busDAO")
public class BusDAO {

    private JdbcTemplate myJdbcTemplate;
    private DataSource dataSource;
    .....
public void setDataSource(DataSource dataSource) {
          this.dataSource = dataSource;
          this.myJdbcTemplate = new JdbcTemplate(dataSource);
       }